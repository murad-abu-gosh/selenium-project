package infra;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static api.CartApi.auth;
import static api.CartApi.ecomToken;


public class HttpFacade {


    //makeHttpRequest: It's a generic method that send Http requests to our Api using specific URL
    //  requestBody that contains the body of request
    public static <T> WrappHttpResponse<T> makeHttpRequest(Class<T> clz, String URL, Map<String, String> headers, HttpMethod method, String requestBody) {
        String result = null;
        CloseableHttpResponse response = null;
        HttpUriRequestBase request = null;
        switch (method) {
            case GET -> request = new HttpGet(URL);
            case POST -> {
                request = new HttpPost(URL);
                ;
                if (headers != null) {
                    for (Map.Entry<String, String> header : headers.entrySet()) {
                        request.addHeader(header.getKey(), header.getValue());
                    }
                }
                System.out.println("HTTPfacade ===" + requestBody);
                System.out.println("Entity--------- " + requestBody.toString());
                request.setEntity(new StringEntity(requestBody));
            }
            case PATCH -> {
                request = new HttpPatch(URL);
                request.setHeader("accept", "application/json");
                request.setHeader("Content-Type", "application/json");
                request.setEntity(new StringEntity(requestBody));
            }
            case DELETE -> request = new HttpDelete(URL);
            case PUT -> {
                request = new HttpPut(URL);
                if (headers != null) {
                    for (Map.Entry<String, String> header : headers.entrySet()) {
                        request.addHeader(header.getKey(), header.getValue());
                    }
                }
                request.setEntity(new StringEntity(requestBody));
            }
        }


        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    System.err.println("Unable to close response.");
                    e.printStackTrace();
                }
            }
        }

        Gson gson = new Gson();
        try {

            System.out.println("status" + response.getCode());
            System.out.println("response" + result);
            if (result.isEmpty()) {
                result = "{}";
            }
            JSONObject jsonObject = new JSONObject(result);

            return new WrappHttpResponse<>(response.getCode(), null, gson.fromJson(result, clz));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

