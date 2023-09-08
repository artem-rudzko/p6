package driver;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Wait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WinDriver {
    private static WindowsDriver driver = null;
    private static final String PATH_TO_DRIVER = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
    private static final String APP_PATH = "C:\\Program Files\\Oracle\\Primavera P6\\P6 Professional\\12.8.25\\Primavera.CacheService.exe";

    public static void start() {
        try {
            Desktop desktop = Desktop.getDesktop();

            File file = new File(PATH_TO_DRIVER);

            /* Check if there is support for Desktop or not */
            if (!Desktop.isDesktopSupported()) {
                System.out.println("not supported");
                return;
            }

            if (file.exists()) {
                System.out.println("Open WinAppDriver.exe\n");
                desktop.open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Encountered Exception\n");
            throw new RuntimeException(e);
        }
    }

    public static void stop() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("taskkill ", "/f", "/IM", "WinAppDriver.exe");
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static WindowsDriver getDriverAndStartDriver() {
        if (driver != null)
            return driver;
        DesiredCapabilities capability = new DesiredCapabilities();

        capability.setCapability("ms:experimental-webdriver", true);
        capability.setCapability("app", APP_PATH);
        capability.setCapability("platformName", "Windows");
        capability.setCapability("deviceName", "Windows10Machine");

        /* Start WinAppDriver.exe so that it can start listening to incoming requests */
        WinDriver.start();

        try {
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capability);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Wait.forSeconds(10);
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
