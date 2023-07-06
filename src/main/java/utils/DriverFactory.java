package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    static WebDriver driver;
    static Properties properties;

    public static WebDriver initialize_Driver(String browser){

        properties = ConfigReader.getProperties();
        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        String url = properties.getProperty("url");
        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        driver.get(url);
        driver.manage().window().maximize();
        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impWait));
        // Page Load Timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageWait));
        return getDriver();

    }

    public static WebDriver getDriver(){
        return driver;
    }

}