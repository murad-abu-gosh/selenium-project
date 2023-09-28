package POM;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Profile_Dashboard extends BasePage {
    WebElement Personal_info;
    String PERSONAL_INFO = "//div[contains(text(), 'פרטים אישיים')]//..//../..//..//div[2]//div";

    private WebElement firstName;
    private WebElement lastName;
    private WebElement phone;
    private WebElement additionalPhone;
    private WebElement sexId;
    private WebElement birthDate;

    private WebElement sex_ID_male_1;



    private WebElement sex_ID_female_2;
    private WebElement sex_ID_other_3;

    public Profile_Dashboard(WebDriver driver) {
        super(driver);
        init();
    }



    @Override
    public void init() {
    Personal_info = waitFunction(By.xpath(PERSONAL_INFO));
    init_elements();
    }

    private void init_elements(){
        firstName = Personal_info.findElement(By.id("f-name"));
        lastName = Personal_info.findElement(By.id("l-name"));
        phone = Personal_info.findElement(By.id("phone"));
        additionalPhone = Personal_info.findElement(By.id("additional_phone"));
//        sexId = Personal_info.findElement(By.id("__BVID__138"));
        birthDate = Personal_info.findElement(By.id("birth_date"));
        sex_ID_male_1= Personal_info.findElement(By.xpath("//input[@value='1']"));
        sex_ID_female_2 = Personal_info.findElement(By.xpath("//input[@value='2']"));
        sex_ID_other_3 = Personal_info.findElement(By.xpath("//input[@value='3']"));

    }
//    private boolean null_checker()
    public String getFirstName() {

        System.out.println("FirstName:");
        if(firstName.getAttribute("value").isEmpty()){
            return null;
        }
        return firstName.getAttribute("value");
    }

    public String getLastName() {
        System.out.println("LastName:");
        if(lastName.getAttribute("value").isEmpty()){
            return null;
        }
        return lastName.getAttribute("value");
    }

    public String getPhone() {
        System.out.println("Phone:");
        if(phone.getAttribute("value").isEmpty()){
            return null;
        }
        return phone.getAttribute("value");
    }

    public String getAdditionalPhone() {
        System.out.println("AdditionalPhone:");
        if(additionalPhone.getAttribute("value").isEmpty()){
            return null;
        }
        return additionalPhone.getAttribute("value");
    }

    public WebElement getSexId() {
        return sexId;
    }

    public String getBirthDate() {
        System.out.println("BirthDate:");
        if(birthDate.getAttribute("value").isEmpty()){
            return null;
        }
        return birthDate.getAttribute("value");
    }

    public boolean getSex_ID_male_1() {
        System.out.println("button 1");
        return sex_ID_male_1.isSelected();
    }

    public boolean getSex_ID_female_2() {
        System.out.println("button 2");
        return sex_ID_female_2.isSelected();
    }

    public boolean getSex_ID_other_3() {
        System.out.println("button 3");

        return sex_ID_other_3.isSelected();
    }
    public String selected_gender(){
        if(getSex_ID_male_1()){
            return "1";
        }
        else if (getSex_ID_female_2()){
            return "2";
        } else if (getSex_ID_other_3()) {
            return "3";
        }else {return "Error! There ara no radio button selected\n ";}

    }

    public void print(){
        System.out.println(getFirstName());
        System.out.println(getLastName());
        System.out.println(getPhone());
        System.out.println(getAdditionalPhone());
        System.out.println(getBirthDate());
        System.out.println(getSex_ID_male_1());
        System.out.println(getSex_ID_female_2());
        System.out.println(getSex_ID_other_3());
    }






}
