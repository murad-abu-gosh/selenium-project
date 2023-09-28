package api;

import infra.HttpFacade;
import infra.HttpMethod;
import infra.WrappHttpResponse;
import logic.response.LoginResponse;

public class CartApi extends ApiClient{


    public static void emptyCart(){
        String url = "https://www.rami-levy.co.il/api/v2/cart";
        // Send the request
        HttpFacade.makeHttpRequest( LoginResponse.class, url , HttpMethod.POST ,"{\"store\":331,\"isClub\":0,\"supplyAt\":\"2023-09-28T13:11:40.712Z\",\"items\":{},\"meta\":null}");
        //
    }

}
