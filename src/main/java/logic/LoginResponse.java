package logic;

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

    public void setUser(User user) {
        this.user = user;
    }

    public Object getDeliveryTimesCustomer() {
        return deliveryTimesCustomer;
    }

    public void setDeliveryTimesCustomer(Object deliveryTimesCustomer) {
        this.deliveryTimesCustomer = deliveryTimesCustomer;
    }

    public Object[] getOrderTokens() {
        return orderTokens;
    }

    public void setOrderTokens(Object[] orderTokens) {
        this.orderTokens = orderTokens;
    }

    public Object getOrder() {
        return order;
    }

    public void setOrder(Object order) {
        this.order = order;
    }

    public Object getCart() {
        return cart;
    }

    public void setCart(Object cart) {
        this.cart = cart;
    }

    public Object[] getShopLists() {
        return shopLists;
    }

    public void setShopLists(Object[] shopLists) {
        this.shopLists = shopLists;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public Object getMeta() {
            return meta;
        }

        public void setMeta(Object meta) {
            this.meta = meta;
        }

        public Object getStore_id() {
            return store_id;
        }

        public void setStore_id(Object store_id) {
            this.store_id = store_id;
        }

        public Object getLocale() {
            return locale;
        }

        public void setLocale(Object locale) {
            this.locale = locale;
        }

        public String getIdentity_card() {
            return identity_card;
        }

        public void setIdentity_card(String identity_card) {
            this.identity_card = identity_card;
        }

        public Object getAccounting_card_id() {
            return accounting_card_id;
        }

        public void setAccounting_card_id(Object accounting_card_id) {
            this.accounting_card_id = accounting_card_id;
        }

        public int getBusiness() {
            return business;
        }

        public void setBusiness(int business) {
            this.business = business;
        }

        public Object getBirth_date() {
            return birth_date;
        }

        public void setBirth_date(Object birth_date) {
            this.birth_date = birth_date;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getAdditional_phone() {
            return additional_phone;
        }

        public void setAdditional_phone(Object additional_phone) {
            this.additional_phone = additional_phone;
        }

        public Object getSex_id() {
            return sex_id;
        }

        public void setSex_id(Object sex_id) {
            this.sex_id = sex_id;
        }

        public Object getEdit_order() {
            return edit_order;
        }

        public void setEdit_order(Object edit_order) {
            this.edit_order = edit_order;
        }

        public int getSend_email() {
            return send_email;
        }

        public void setSend_email(int send_email) {
            this.send_email = send_email;
        }

        public int getSend_sms() {
            return send_sms;
        }

        public void setSend_sms(int send_sms) {
            this.send_sms = send_sms;
        }

        public Object getSubscribe_at() {
            return subscribe_at;
        }

        public void setSubscribe_at(Object subscribe_at) {
            this.subscribe_at = subscribe_at;
        }

        public Object getSubscribe_ip() {
            return subscribe_ip;
        }

        public void setSubscribe_ip(Object subscribe_ip) {
            this.subscribe_ip = subscribe_ip;
        }

        public String getClub_accept_at() {
            return club_accept_at;
        }

        public void setClub_accept_at(String club_accept_at) {
            this.club_accept_at = club_accept_at;
        }

        public String getClub_accept_ip() {
            return club_accept_ip;
        }

        public void setClub_accept_ip(String club_accept_ip) {
            this.club_accept_ip = club_accept_ip;
        }

        public int getClub_accept() {
            return club_accept;
        }

        public void setClub_accept(int club_accept) {
            this.club_accept = club_accept;
        }

        public int getSend_club_database() {
            return send_club_database;
        }

        public void setSend_club_database(int send_club_database) {
            this.send_club_database = send_club_database;
        }

        public Object getDisabled_at() {
            return disabled_at;
        }

        public void setDisabled_at(Object disabled_at) {
            this.disabled_at = disabled_at;
        }

        public Object getActivated_at() {
            return activated_at;
        }

        public void setActivated_at(Object activated_at) {
            this.activated_at = activated_at;
        }

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }

        public Object getArea_id() {
            return area_id;
        }

        public void setArea_id(Object area_id) {
            this.area_id = area_id;
        }

        public Object getDeactivated_at() {
            return deactivated_at;
        }

        public void setDeactivated_at(Object deactivated_at) {
            this.deactivated_at = deactivated_at;
        }

        public Object getCustomer_id_club() {
            return customer_id_club;
        }

        public void setCustomer_id_club(Object customer_id_club) {
            this.customer_id_club = customer_id_club;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object[] getOrders() {
            return orders;
        }

        public void setOrders(Object[] orders) {
            this.orders = orders;
        }

        public Object[] getCards() {
            return cards;
        }

        public void setCards(Object[] cards) {
            this.cards = cards;
        }

        public Map<String, Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(Map<String, Address> addresses) {
            this.addresses = addresses;
        }

        public String getPopularProducts() {
            return popularProducts;
        }

        public void setPopularProducts(String popularProducts) {
            this.popularProducts = popularProducts;
        }

        public Object[] getFeatures() {
            return features;
        }

        public void setFeatures(Object[] features) {
            this.features = features;
        }

        public Object[] getCoupons() {
            return coupons;
        }

        public void setCoupons(Object[] coupons) {
            this.coupons = coupons;
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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getApartment() {
                return apartment;
            }

            public void setApartment(String apartment) {
                this.apartment = apartment;
            }

            public Object getArea() {
                return area;
            }

            public void setArea(Object area) {
                this.area = area;
            }

            public Object getArea_id() {
                return area_id;
            }

            public void setArea_id(Object area_id) {
                this.area_id = area_id;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCity_id() {
                return city_id;
            }

            public void setCity_id(int city_id) {
                this.city_id = city_id;
            }

            public int get_default() {
                return _default;
            }

            public void set_default(int _default) {
                this._default = _default;
            }

            public Object getEntrance() {
                return entrance;
            }

            public void setEntrance(Object entrance) {
                this.entrance = entrance;
            }

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getStore_id() {
                return store_id;
            }

            public void setStore_id(Object store_id) {
                this.store_id = store_id;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public Integer getStreet_id() {
                return street_id;
            }

            public void setStreet_id(Integer street_id) {
                this.street_id = street_id;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }


            // Getter and setter methods for all the fields go here
        }
    }
}
