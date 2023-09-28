package infra;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import java.io.IOException;


public class HttpFacade {


    //makeHttpRequest: It's a generic method that send Http requests to our Api using specific URL
    //  requestBody that contains the body of request
    public static <T> WrappHttpResponse <T> makeHttpRequest(Class<T> clz, String URL, HttpMethod method, String requestBody) {
        String result = null;
        CloseableHttpResponse response = null;


        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            if (method == HttpMethod.GET) {
                HttpGet request = new HttpGet(URL);
                response = httpClient.execute(request);
            } else if (method == HttpMethod.POST) {
                HttpPost request = new HttpPost(URL);
                request.setHeader("accept", "application/json");
                request.setHeader("Content-Type", "application/json");
//                request.setHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjIxNzE5ZDM2NzI0OGYyZDAwY2RkMThmM2U5ZmJhNGYxYTU1OTRkYjZlYjI3ODY4ZTlmZmJhNWI0YTdmNTc2Y2IwNDg3N2FiNjY1ODMwYWNjIn0.eyJhdWQiOiIzIiwianRpIjoiMjE3MTlkMzY3MjQ4ZjJkMDBjZGQxOGYzZTlmYmE0ZjFhNTU5NGRiNmV$");
                request.setHeader("Ecomtoken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvYXBpLXByb2QucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6XC9cL2FwaS1wcm9kLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTY5NTkwNzMzMiwibmJmIjoxNjk1OTA3MzkyLCJleHAiOjE2OTU5OTM3MzIsImlkIjo4ODkzNjksImVtYWlsIjoiYWFhYWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NDc1OTMifQ.n2s6LeGU27F_QuZT5MZEAF16zI9EqdTIJ2wIxSV7Wtc");
                request.setEntity(new StringEntity(requestBody));
                response = httpClient.execute(request);
            } else if (method == HttpMethod.PATCH) {
                HttpPatch request = new HttpPatch(URL);
                request.setHeader("accept", "application/json");
                request.setHeader("Content-Type", "application/json");
                request.setEntity(new StringEntity(requestBody));
                response = httpClient.execute(request);

            } else if (method == HttpMethod.DELETE) {
                HttpDelete request = new HttpDelete(URL);
                request.setHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjIxNzE5ZDM2NzI0OGYyZDAwY2RkMThmM2U5ZmJhNGYxYTU1OTRkYjZlYjI3ODY4ZTlmZmJhNWI0YTdmNTc2Y2IwNDg3N2FiNjY1ODMwYWNjIn0.eyJhdWQiOiIzIiwianRpIjoiMjE3MTlkMzY3MjQ4ZjJkMDBjZGQxOGYzZTlmYmE0ZjFhNTU5NGRiNmV$");
                request.setHeader("Ecomtoken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvYXBpLXByb2QucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6XC9cL2FwaS1wcm9kLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTY5NTc1MjI0OSwibmJmIjoxNjk1NzUyMzA5LCJleHAiOjE2OTU4Mzg2NDksImlkIjo4ODkzNjksImVtYWlsIjoiYWFhYWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NDc1OTMifQ.5Ulu880_H6KrX1wOhRjpPEStPQ0pI2Yg4kA7ESUUWlo");


                response = httpClient.execute(request);

            }

            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    // Handle the exception if necessary
                }
            }
        }


        Gson gson = new Gson();
        try {

            System.out.println("status" +  response.getCode());
            System.out.println("respone" + result);
            JSONObject jsonObject = new JSONObject(result);
            return new WrappHttpResponse(response.getCode(), null,gson.fromJson(result, clz));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

