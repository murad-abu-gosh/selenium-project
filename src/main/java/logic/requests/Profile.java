package logic.requests;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Profile {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        private String phone;

        @JsonProperty("additional_phone")
        private String additionalPhone;

        @JsonProperty("sex_id")
        private String sexId;

        @JsonProperty("birth_date")
        private String birthDate;

    public Profile(String firstName, String lastName, String phone, String additionalPhone, String sexId, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.additionalPhone = additionalPhone;
        this.sexId = sexId;
        this.birthDate = birthDate;
    }

    // Getter and Setter methods for the above fields (omitted for brevity)

        @Override
        public String toString() {
            return "UserData{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phone='" + phone + '\'' +
                    ", additionalPhone='" + additionalPhone + '\'' +
                    ", sexId='" + sexId + '\'' +
                    ", birthDate='" + birthDate + '\'' +
                    '}';
        }


}
