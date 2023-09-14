package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import infra.Account;
import infra.HttpFacade;
import infra.HttpMethod;
import infra.WrappHttpResponse;
import org.json.JSONObject;

import java.io.IOException;

public class ApiClient {
    private static final String BASE_URL = "https://www.rami-levy.co.il/api/catalog?";

    public static WrappHttpResponse<JSONObject> login(Account account) throws IOException {
        String url = "https://api-prod.rami-levy.co.il/api/v2/site/auth/login";



        // Serialize restaurant object to JSON
        String requestBody = serializeToJson(account);
        System.out.println("requestBody" + requestBody);

        // Send the request
        return HttpFacade.makeHttpRequest( JSONObject.class, url , HttpMethod.POST ,requestBody);
    }

//    public static   WrappHttpResponse<Restaurant> createRestaurant(Object restaurant) throws IOException {
//        String url = BASE_URL + "restaurant";
//
//        // Serialize restaurant object to JSON
//        String requestBody = serializeToJson(restaurant);
//
//
//        // Send the request
//        return  HttpFacade.makeHttpRequest(url,null,  requestBody , HttpMethod.POST);
//    }
//    public static   WrappHttpResponse<Restaurant> Reset() throws IOException {
//        String url = BASE_URL + "reset";
//
//
//
//        // Send the request
//        return  HttpFacade.makeHttpRequest(url,null,  null , HttpMethod.POST);
//    }

    private static String serializeToJson(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(obj);
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
