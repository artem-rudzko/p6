package tests;

import driver.WinDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void runDriver(){
        WinDriver.getDriverAndStartDriver();
    }

    @AfterSuite
    public void tearDown() {
        WinDriver.tearDown();
    }
}
