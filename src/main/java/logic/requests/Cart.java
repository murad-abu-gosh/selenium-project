package logic.requests;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public class Cart {


    @JsonProperty("store")
    private int store;

    @JsonProperty("isClub")
    private int isClub;

    @JsonProperty("supplyAt")
    private String supplyAt;

    @JsonProperty("items")
    private Map<String, String> items;

    @JsonProperty("meta")
    private String meta;

    // Constructor
    public Cart(@JsonProperty("store") int store,
                @JsonProperty("isClub") int isClub,
                @JsonProperty("supplyAt") String supplyAt,
                @JsonProperty("items") Map<String, String> items,
                @JsonProperty("meta") String meta) {
        this.store = store;
        this.isClub = isClub;
        this.supplyAt = supplyAt;
        this.items = items;
        this.meta = meta;
    }
//    String x = {"store":331,"isClub":0,"supplyAt":"2023-09-26T16:31:58.178Z","items":{"292":"1.00","164854":"1.00","310196":"1.00"},"meta":null}


}


