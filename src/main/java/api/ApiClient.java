package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import logic.requests.Account;
import infra.HttpFacade;
import infra.HttpMethod;
import infra.WrappHttpResponse;
import logic.requests.Address;
import logic.response.LoginResponse;
import java.io.IOException;

public class ApiClient {
    private static final String BASE_URL = "https://www.rami-levy.co.il/api/catalog?";

    public static WrappHttpResponse<LoginResponse> login(Account account) throws IOException {
        String url = "https://api-prod.rami-levy.co.il/api/v2/site/auth/login";



        // Serialize restaurant object to JSON
        String requestBody = serializeToJson(account);
        System.out.println("requestBody" + requestBody);

        // Send the request
        return HttpFacade.makeHttpRequest( LoginResponse.class, url , HttpMethod.POST ,requestBody);
    }

    public  static  WrappHttpResponse<Address> add_address (Address address){
    String url ="https://api-prod.rami-levy.co.il/api/v2/site/clubs/addresses";

        String requestBody = serializeToJson(address);
        System.out.println("requestBody" + requestBody);
        return HttpFacade.makeHttpRequest( Address.class, url , HttpMethod.POST ,requestBody);
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
