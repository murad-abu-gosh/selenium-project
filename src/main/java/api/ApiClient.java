package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import logic.requests.Account;
import infra.HttpFacade;
import infra.HttpMethod;
import infra.WrappHttpResponse;
import logic.requests.Address;
import logic.requests.Profile;
import logic.response.LoginResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private static final String BASE_URL = "https://www.rami-levy.co.il/api/catalog?";

    public static WrappHttpResponse<LoginResponse> login(Account account) throws IOException {
        String url = "https://api-prod.rami-levy.co.il/api/v2/site/auth/login";
        Map <String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json, text/plain, */*n; charset=UTF-8");
        headers.put("Accept","application/json, text/plain, */*");



        // Serialize restaurant object to JSON
        String requestBody = serializeToJson(account);
        System.out.println("requestBody" + requestBody);

        // Send the request
        return HttpFacade.makeHttpRequest( LoginResponse.class, url,headers , HttpMethod.POST ,requestBody);
    }

    public  static  WrappHttpResponse<Address> add_address (Address address){
    String url ="https://api-prod.rami-levy.co.il/api/v2/site/clubs/addresses";
        Map <String,String> headers = new HashMap<>();
        headers.put("Accept","application/json, text/plain, */*");
        headers.put("Accept-Encoding","gzip, deflate, br");
        headers.put("Accept-Language","he-IL,he;q=0.9,en-US;q=0.8,en;q=0.7");
        headers.put("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjIxNzE5ZDM2NzI0OGYyZDAwY2RkMThmM2U5ZmJhNGYxYTU1OTRkYjZlYjI3ODY4ZTlmZmJhNWI0YTdmNTc2Y2IwNDg3N2FiNjY1ODMwYWNjIn0.eyJhdWQiOiIzIiwianRpIjoiMjE3MTlkMzY3MjQ4ZjJkMDBjZGQxOGYzZTlmYmE0ZjFhNTU5NGRiNmV$");
        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("Ecomtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvYXBpLXByb2QucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6XC9cL2FwaS1wcm9kLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTY5NTU3MTMyNywibmJmIjoxNjk1NTcxMzg3LCJleHAiOjE2OTU2NTc3MjcsImlkIjo4ODkzNjksImVtYWlsIjoiYWFhYWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NDc1OTMifQ.3joiDLT3D4Y5hLZEf2SeOr6Zt4gh_m6jUC3Dhc8YiDA");
        headers.put("Locale","he");


        String requestBody = serializeToJson(address);
        System.out.println("requestBody" + requestBody);
        return HttpFacade.makeHttpRequest( Address.class, url,headers, HttpMethod.POST ,requestBody);
    }


    public  static  WrappHttpResponse<Profile> update_profile (Profile profile){
        String url ="https://api-prod.rami-levy.co.il/api/v2/site/clubs/addresses";
        Map <String,String> headers = new HashMap<>();
        headers.put("Accept","application/json, text/plain, */*");
        headers.put("Accept-Encoding","gzip, deflate, br");
        headers.put("Accept-Language","he-IL,he;q=0.9,en-US;q=0.8,en;q=0.7");
        headers.put("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjIxNzE5ZDM2NzI0OGYyZDAwY2RkMThmM2U5ZmJhNGYxYTU1OTRkYjZlYjI3ODY4ZTlmZmJhNWI0YTdmNTc2Y2IwNDg3N2FiNjY1ODMwYWNjIn0.eyJhdWQiOiIzIiwianRpIjoiMjE3MTlkMzY3MjQ4ZjJkMDBjZGQxOGYzZTlmYmE0ZjFhNTU5NGRiNmV$");
        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("Ecomtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvYXBpLXByb2QucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6XC9cL2FwaS1wcm9kLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTY5NTgzNDc0OSwibmJmIjoxNjk1ODM0ODA5LCJleHAiOjE2OTU5MjExNDksImlkIjo4ODkzNjksImVtYWlsIjoiYWFhYWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NDc1OTMifQ.B_6VIazpHRO9mJHnFFfUXenBIxu1pr88FJbFd_Y76d8");
//        headers.put("Locale","he");


        String requestBody = serializeToJson(profile);
        System.out.println("requestBody" + requestBody);
        return HttpFacade.makeHttpRequest( Profile.class, url,headers, HttpMethod.PUT ,requestBody);
    }



    public static String serializeToJson(Object obj) {
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
