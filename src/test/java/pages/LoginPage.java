package pages;

import driver.WinDriver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage {
    @FindBy(name = "LoginNameInput")
    WebElement loginField;
    @FindBy(name = "PasswordInput")
    WebElement passwordField;
    @FindBy(name = "CONNECT")
    WebElement connectButton;

    public LoginPage() {
        PageFactory.initElements(WinDriver.getDriverAndStartDriver(), this);
    }

}
