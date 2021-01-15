import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

class RandomWordAPI {
    private HttpsURLConnection getHttpsClient(String url) throws Exception {

        // Security section START
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }};

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        // Security section END

        HttpsURLConnection client = (HttpsURLConnection) new URL(url).openConnection();
        //add request header
        client.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        return client;
    }

    String getWord() throws Exception {
        HttpsURLConnection client = getHttpsClient("https://random-word-api.herokuapp.com/word?number=1");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            String jsSingleArrayLine = in.readLine();
            return jsSingleArrayLine.substring(2, jsSingleArrayLine.length() - 2);
        }
    }
}
