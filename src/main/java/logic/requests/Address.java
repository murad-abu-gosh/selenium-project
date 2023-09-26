package logic.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Address {
    private String name;

    private int cityId;

    private String city;

    private String street;

    private String streetNumber;

    private String zip;

    private String apartment;

    private String entrance;

    private String floor;

    // Constructors, getters, and setters

    // Default constructor
    public Address() {}

    // Parameterized constructor
    public Address(String name, int cityId, String city, String street, String streetNumber, String zip, String apartment, String entrance, String floor) {
        this.name = name;
        this.cityId = cityId;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.zip = zip;
        this.apartment = apartment;
        this.entrance = entrance;
        this.floor = floor;
    }

    // Getters and setters for the fields

    // Other methods as needed

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", cityId=" + cityId +
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
