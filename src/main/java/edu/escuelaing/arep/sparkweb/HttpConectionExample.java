package edu.escuelaing.arep.sparkweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=";
    private static final String API_KEY = "&apikey=Q1QZFVJQ21K7C6XM";

    public static <JSONObject> String getData(String ticker) throws IOException {

        String responseSTR = "None";
        String FINAL_URL = GET_URL+ticker+API_KEY;
//        System.out.println(FINAL_URL);
        URL obj = new URL(FINAL_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            responseSTR = response.toString();
            System.out.println(responseSTR);
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return responseSTR;
    }


}