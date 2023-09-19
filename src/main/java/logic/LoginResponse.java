package logic;

import java.util.Arrays;
import java.util.Map;

public class LoginResponse {


    private User user;
    private Object deliveryTimesCustomer;
    private Object[] orderTokens;
    private Object order;
    private Object cart;
    private Object[] shopLists;

    // Getter and setter methods for all the fields go here
    public User getUser() {
        return user;
    }


    public static class User {
        private int id;
        private String first_name;
        private String last_name;
        private String email;
        private String token;
        private String user_id;
        private Object meta;
        private Object store_id;
        private Object locale;
        private String identity_card;
        private Object accounting_card_id;
        private int business;
        private Object birth_date;
        private Object phone;
        private Object additional_phone;
        private Object sex_id;
        private Object edit_order;
        private int send_email;
        private int send_sms;
        private Object subscribe_at;
        private Object subscribe_ip;
        private String club_accept_at;
        private String club_accept_ip;
        private int club_accept;
        private int send_club_database;
        private Object disabled_at;
        private Object activated_at;
        private Object deleted_at;
        private Object area_id;
        private Object deactivated_at;
        private Object customer_id_club;
        private String name;
        private Object[] orders;
        private Object[] cards;
        private Map<String, Address> addresses;
        private String popularProducts;
        private Object[] features;
        private Object[] coupons;



        public String getFirst_name() {
            return first_name;
        }



        // Getter and setter methods for all the fields go here

        public static class Address {
            private int id;
            private String apartment;
            private Object area;
            private Object area_id;
            private String city;
            private int city_id;
            private int _default;
            private Object entrance;
            private String floor;
            private Object name;
            private Object store_id;
            private String street;
            private Integer street_id;
            private String street_number;
            private String zip;



            // Getter and setter methods for all the fields go here
        }
    }
}
