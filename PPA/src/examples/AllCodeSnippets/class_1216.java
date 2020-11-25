package examples.AllCodeSnippets; 
// package me.gilo.a55thavenue.data;

import android.util.Base64;
import android.util.Log;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Aron on 10/31/2015.
 */
public class class_1216 {

    static String oauth_nonce = ";
    static String oauth_timestamp = ";
    static String oauth_signature_method = "HMAC-SHA1";

    static ArrayList<NameValuePair> params;

    public static API createAPI(final String endpoint) {

        setParams(endpoint);

        // Define the interceptor, add authentication headers
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                HttpUrl.Builder builder = chain.request().httpUrl().newBuilder();
                for (NameValuePair entry : params) {
                    builder.addQueryParameter(entry.getName(), entry.getValue());
                }

                Request newRequest = chain.request()
                        .newBuilder()
                        .url(builder.build())
                        .build();

                return chain.proceed(newRequest);
            }
        };


        // Add the interceptor to OkHttpClient
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(interceptor);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit.create(API.class);
    }

    public static ArrayList<NameValuePair> setParams(String endpoint) {

        final String uri = API.BASE_URL + endpoint;

        oauth_nonce = getOauth_nonce();
        oauth_timestamp = getOauth_timestamp();

        params = new ArrayList<>();
        params.add(new BasicNameValuePair("oauth_consumer_key", API.CONSUMER_KEY));
        params.add(new BasicNameValuePair("oauth_nonce", oauth_nonce));
        params.add(new BasicNameValuePair("oauth_timestamp", oauth_timestamp));
        params.add(new BasicNameValuePair("oauth_signature_method", oauth_signature_method));

        Collections.sort(params, new SortParams());

        String encodedParams = URLEncodedUtils.format(params, "utf-8");
        Log.d("encodedParamString", encodedParams);

        String string_to_sign = ";
        try {
            string_to_sign = (new StringBuilder("POST&")).append(URLEncoder.encode(uri, "utf-8")).append("&").append(URLEncoder.encode(encodedParams, "utf-8")).toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Log.d("string to sign", string_to_sign);

        try {
            Mac mac = Mac.getInstance("HMAC-SHA1");
            String secret = API.CONSUMER_SECRET;
            if (API.WP_API_VERSION.equals("3")) {
                secret = API.CONSUMER_SECRET + "&";
            }
            mac.init(new SecretKeySpec(secret.getBytes("utf-8"), "HMAC-SHA1"));
            String signature = Base64.encodeToString(mac.doFinal(string_to_sign.getBytes("utf-8")), 0).trim();
            Log.d("signature", signature);
            params.add(new BasicNameValuePair("oauth_signature", signature));
        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return params;
    }

    public static String getOauth_nonce() {
        return (new StringBuilder(String.valueOf(Math.random() * 100000000D))).toString();
    }

    public static String getOauth_timestamp() {
        long stamp = (long) (System.currentTimeMillis() / 1000D);
        Log.d("stamp", stamp + ");
        return (new StringBuilder(String.valueOf(stamp))).toString();
    }

    static class SortParams implements Comparator<NameValuePair> {

        @Override
        public int compare(NameValuePair nameValuePair1, NameValuePair nameValuePair2) {
            return nameValuePair1.getName().compareTo(nameValuePair2.getName());
        }
    }
}
