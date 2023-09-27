package logic.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
@Data
public class Address {
    @JsonProperty("name")
    private String name;

    @JsonProperty("city_id")
    private int cityId;

    @JsonProperty("street_id")
    private int streetId;

    @JsonProperty("city")
    private String city;

    @JsonProperty("street")
    private String street;

    @JsonProperty("street_number")
    private String streetNumber;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("apartment")
    private String apartment;

    @JsonProperty("entrance")
    private String entrance;

    @JsonProperty("floor")
    private String floor;

    // Getters and setters (or you can generate them using your IDE)
    public Address(String name, int cityId, int streetId, String city, String street, String streetNumber, String zip, String apartment, String entrance, String floor) {
        this.name = name;
        this.cityId = cityId;
        this.streetId = streetId;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.zip = zip;
        this.apartment = apartment;
        this.entrance = entrance;
        this.floor = floor;
    }
    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", cityId=" + cityId +
                ", streetId=" + streetId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", zip='" + zip + '\'' +
                ", apartment='" + apartment + '\'' +
                ", entrance='" + entrance + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
