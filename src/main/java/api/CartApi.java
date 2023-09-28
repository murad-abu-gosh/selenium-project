package api;

import infra.HttpFacade;
import infra.HttpMethod;
import logic.requests.Account;
import logic.requests.Cart;

import java.util.HashMap;
import java.util.Map;

public class CartApi extends ApiClient{
    private final static String url = "https://www.rami-levy.co.il/api/v2/cart";
    public final static String auth = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjIxNzE5ZDM2NzI0OGYyZDAwY2RkMThmM2U5ZmJhNGYxYTU1OTRkYjZlYjI3ODY4ZTlmZmJhNWI0YTdmNTc2Y2IwNDg3N2FiNjY1ODMwYWNjIn0.eyJhdWQiOiIzIiwianRpIjoiMjE3MTlkMzY3MjQ4ZjJkMDBjZGQxOGYzZTlmYmE0ZjFhNTU5NGRiNmV$";
    public final static String ecomToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvYXBpLXByb2QucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6XC9cL2FwaS1wcm9kLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTY5NTkxNDA3MiwibmJmIjoxNjk1OTE0MTMyLCJleHAiOjE2OTYwMDA0NzIsImlkIjo4ODkzNjksImVtYWlsIjoiYWFhYWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NDc1OTMifQ._GQWE4TMwcCcAr8HhYDG-uQJSNnjpD1S-xcJLJ8XMbk";
    private final static String emptyBodyRequest = "{\"store\":331,\"isClub\":0,\"items\":{},\"meta\":null}";
    private final static String bambaBodyRequest = "{\"store\":331,\"isClub\":0,\"supplyAt\":\"2023-09-28T15:14:48.250Z\",\"items\":{\"292\":\"1.00\",\"317\":\"2.00\",\"164854\":\"1.00\",\"368250\":\"3.00\"},\"meta\":null}";

    public static void emptyCart() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", auth);
        headers.put("Ecomtoken", ecomToken);
        // Send the request
        HttpFacade.makeHttpRequest(Account.class, url, headers, HttpMethod.POST, emptyBodyRequest);
    }



    public static void addBambaToCart(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", auth);
        headers.put("Ecomtoken", ecomToken);
        HttpFacade.makeHttpRequest(Account.class, url, headers, HttpMethod.POST, bambaBodyRequest);
    }

    public static void main(String[] args) {
        addBambaToCart();
        emptyCart();
    }

}
