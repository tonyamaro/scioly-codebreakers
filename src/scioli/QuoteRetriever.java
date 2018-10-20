package scioli;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class QuoteRetriever {

    public String getQUote() throws IOException {
        try {

            final URL url = new URL("http://quotes.rest/qod.json?category=inspire");
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            final String json;
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                json = buffer.lines().collect(Collectors.joining("\n"));
            } finally {
                conn.disconnect();
            }

            System.out.println(json);

            final JSONObject obj = new JSONObject(json);
            //jsonBuilder.toString());
            String quoteString = obj.getJSONObject("contents")
                    .getJSONArray("quotes")
                    .getJSONObject(0)
                    .getString("quote");
            if (quoteString.length() > 100) {
                quoteString = quoteString.substring(0, quoteString.indexOf('.') + 1);
            }

            return quoteString;


        }finally {

        }

    }


}
