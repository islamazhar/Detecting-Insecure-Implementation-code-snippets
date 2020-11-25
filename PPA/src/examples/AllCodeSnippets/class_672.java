package examples.AllCodeSnippets; 
// package com.example.https;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;

import android.content.Context;
import android.os.Build;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class class_672 extends DefaultHttpClient {

    final Context context;

    public MyHttpClient(Context context) {
        this.context = context;
    }

    @Override
    protected ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        // Register for port 443 our SSLSocketFactory with our keystore
        // to the ConnectionManager
        registry.register(new Scheme("https", newSslSocketFactory(), 443));
        return new SingleClientConnManager(getParams(), registry);
    }

    private SSLSocketFactory newSslSocketFactory() {
        try {
            // Trust manager / truststore
            KeyStore trustStore=KeyStore.getInstance(KeyStore.getDefaultType());

            // If we're on an OS version prior to Ice Cream Sandwich (4.0) then use the standard way to get the system
            //   trustStore -- System.getProperty() else we need to use the special name to get the trustStore KeyStore
            //   instance as they changed their trustStore implementation.
            if (Build.VERSION.RELEASE.compareTo("4.0") < 0) {
                TrustManagerFactory trustManagerFactory=TrustManagerFactory
                        .getInstance(TrustManagerFactory.getDefaultAlgorithm());
                FileInputStream trustStoreStream=new FileInputStream(System.getProperty("javax.net.ssl.trustStore"));
                trustStore.load(trustStoreStream, null);
                trustManagerFactory.init(trustStore);
                trustStoreStream.close();
            } else {
                trustStore=KeyStore.getInstance("AndroidCAStore");
            }

            InputStream certificateStream = context.getResources().openRawResource(R.raw.mykst);
            KeyStore keyStore=KeyStore.getInstance("BKS");
            try {
                keyStore.load(certificateStream, "mypassword".toCharArray());
                Enumeration<String> aliases=keyStore.aliases();
                while (aliases.hasMoreElements()) {
                    String alias=aliases.nextElement();
                    if (keyStore.getCertificate(alias).getType().equals("X.509")) {
                        X509Certificate cert=(X509Certificate)keyStore.getCertificate(alias);
                        if (new Date().after(cert.getNotAfter())) {
                            // This certificate has expired
                            return null;
                        }
                    }
                }
            } catch (IOException ioe) {
                // This occurs when there is an incorrect password for the certificate
                return null;
            } finally {
                certificateStream.close();
            }

            KeyManagerFactory keyManagerFactory=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "mypassword".toCharArray());

            return new SSLSocketFactory(keyStore, "mypassword", trustStore);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
