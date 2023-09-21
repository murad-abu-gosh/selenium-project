package POM;

import org.openqa.selenium.WebDriver;

public class RamiLeviHomePage extends BasePage {
    private LoginComponent loginComponent;

    public RamiLeviHomePage(WebDriver driver){
        super(driver);
        init(driver);
    }

    @Override
    public void init(WebDriver driver) {
        this.loginComponent = new LoginComponent(driver);
    }


    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    public void setLoginComponent(LoginComponent loginComponent) {
        this.loginComponent = loginComponent;
    }
}
