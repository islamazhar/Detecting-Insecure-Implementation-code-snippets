SSLContext sc = SSLContext.getInstance("TLS");
TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        return;
}
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        return;
    }
} };
sc.init(null, trustAllCerts, new SecureRandom());
HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
HttpURLConnection = connection = endPoint.openConnection();
