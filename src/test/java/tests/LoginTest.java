package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Wait;

public class LoginTest extends BaseTest {


    @Test(description = "Check that login functionality works correctly")
    public void test_mouse_interactions() {
        LoginPage loginPage = new LoginPage();
        loginPage.getLoginField().sendKeys("artsiomr");
        loginPage.getPasswordField().sendKeys("artsiomr");
        loginPage.getConnectButton().click();
        Wait.forSeconds(10);
    }
}
