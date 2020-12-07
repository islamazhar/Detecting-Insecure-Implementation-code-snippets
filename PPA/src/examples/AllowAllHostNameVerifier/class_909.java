package examples.AllowAllHostNameVerifier; 
// package com.nweave.utils;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyStore;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nweave.view.ProductArrayAdapter;

public class class_909 {
    private ProductArrayAdapter productArrayAdapter;

    public ImageDownloader(ProductArrayAdapter productArrayAdapter) {
        this.productArrayAdapter = productArrayAdapter;
    }

    public void download(String name, String url, ImageView imageView,
            ProgressBar progressBar) {
        if (cancelPotentialDownload(url, imageView)) {
            BitmapDownloaderTask bitmapDownloaderTask = new BitmapDownloaderTask(
                    name, imageView, progressBar);
            DownloadedDrawable downloadedDrawable = new DownloadedDrawable(
                    bitmapDownloaderTask);
            imageView.setImageDrawable(downloadedDrawable);
            bitmapDownloaderTask.execute(url);
        }
    }

    private class BitmapDownloaderTask extends AsyncTask<String, Void, Bitmap> {
        String url;
        private final WeakReference<ImageView> imageViewReference;
        private final String productName;
        private final ProgressBar progressbar;

        public BitmapDownloaderTask(String name, ImageView imageView,
                ProgressBar progressBar) {
            imageViewReference = new WeakReference<ImageView>(imageView);
            productName = name;
            progressbar = progressBar;
        }

        
        protected Bitmap doInBackground(String... params) {
            HttpResponse response = null;
            HttpClient httpsClient = getHttpsClient();
            HttpGet httpGet = new HttpGet();
            try {
                httpGet.setURI(new URI(params[0]));

                response = httpsClient.execute(httpGet);
                Bitmap currentBitMap = BitmapFactory.decodeStream(response
                        .getEntity().getContent());
                productArrayAdapter.cacheImages.saveImages(productName,
                        currentBitMap);
                return currentBitMap;
            } catch (URISyntaxException e) {
                Log.e(ImageDownloader.class.getSimpleName() + ":doInBackground",
                        e.getMessage());
            } catch (ClientProtocolException e) {
                Log.e(ImageDownloader.class.getSimpleName() + ":doInBackground",
                        e.getMessage());
            } catch (IOException e) {
                Log.e(ImageDownloader.class.getSimpleName() + ":doInBackground",
                        e.getMessage());
            }
            return null;
        }

        
        protected void onPostExecute(Bitmap result) {
            if (isCancelled()) {
                result = null;
            }
            if (imageViewReference != null) {
                ImageView imageView = imageViewReference.get();
                BitmapDownloaderTask bitmapDownloaderTask = ImageDownloader
                        .getBitmapDownloaderTask(imageView);
                if (this == bitmapDownloaderTask) {
                    imageView.setImageBitmap(result);
                    imageView.setVisibility(View.VISIBLE);
                    progressbar.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    private static class DownloadedDrawable extends ColorDrawable {
        private final WeakReference<BitmapDownloaderTask> bitmapDownloaderTaskReference;

        public DownloadedDrawable(BitmapDownloaderTask bitmapDownloaderTask) {
            bitmapDownloaderTaskReference = new WeakReference<BitmapDownloaderTask>(
                    bitmapDownloaderTask);
        }

        public BitmapDownloaderTask getBitmapDownloaderTask() {
            return bitmapDownloaderTaskReference.get();
        }
    }

    private static boolean cancelPotentialDownload(String url,
            ImageView imageView) {
        BitmapDownloaderTask bitmapDownloaderTask = getBitmapDownloaderTask(imageView);
        if (bitmapDownloaderTask != null) {
            String bitmapUrl = bitmapDownloaderTask.url;
            if ((bitmapUrl == null) || (!bitmapUrl.equals(url))) {
                bitmapDownloaderTask.cancel(true);
            } else {
                return false;
            }
        }
        return true;
    }

    private static BitmapDownloaderTask getBitmapDownloaderTask(
            ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof DownloadedDrawable) {
                DownloadedDrawable downloadedDrawable = (DownloadedDrawable) drawable;
                return downloadedDrawable.getBitmapDownloaderTask();
            }
        }
        return null;
    }

    private static HttpClient getHttpsClient() {
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore
                    .getDefaultType());
            trustStore.load(null, null);
            SSLSocketFactory sslSocketFactory = new MySSLSocketFactory(
                    trustStore);
            sslSocketFactory
                    .setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory
                    .getSocketFactory(), 80));
            registry.register(new Scheme("https", sslSocketFactory, 443));
            ClientConnectionManager ccm = new ThreadSafeClientConnManager(
                    params, registry);
            return new DefaultHttpClient(ccm, params);
        } catch (Exception e) {
            Log.e(ImageDownloader.class.getSimpleName() + ":getHttpsClient",
                    e.getMessage());
            return new DefaultHttpClient();
        }
    }
}
