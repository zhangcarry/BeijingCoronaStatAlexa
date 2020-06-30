import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaGetRequest {

    private static HttpURLConnection con;

    public static CoronaCase getCoronaCase() throws IOException {

        String url = "https://api-corona.azurewebsites.net/country/cn/beijing";

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            StringBuilder content;


            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {

                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            JSONObject js = JSON.parseObject(content.toString());
            String country = js.getString("Country_Region");
            String state = js.getString("Province_State");
            int active = js.getIntValue("Active");
            int death = js.getIntValue("Deaths");
            int confirmed = js.getIntValue("Confirmed");
            return new CoronaCase(country,state,confirmed,death,active);
        } finally {
            con.disconnect();
        }
    }
}