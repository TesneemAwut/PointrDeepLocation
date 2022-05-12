package com.pointr.TestUtility;
import com.pointr.TestUtility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;

public class BasePage {

    public static WebDriver driver;
    public static void setUpBrowser(String browserName) {
            if(browserName.equalsIgnoreCase("chrome")){
                String systemName = System.getProperty("os.name");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                if (systemName.contains("Mac")) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    Log.info("Chrome Browser has been opened");
                } else if (systemName.contains("Windows")) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    Log.info("Chrome Browser has been opened");
                } else {
                    WebDriverManager.chromedriver().setup();
                    chromeOptions.addArguments(Arrays.asList("--headless", "--dosan-gpu"));
                    chromeOptions.addArguments("window-size=1920,1080");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().deleteAllCookies();
                    Log.info("Chrome Browser has been opened");

                }
            }
            else if (browserName.equalsIgnoreCase("firefox")){
                String systemName = System.getProperty("os.name");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                if (systemName.contains("Mac")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    Log.info("Firefox Browser has been opened");
                } else if (systemName.contains("Windows")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    Log.info("Firefox Browser has been opened");
                } else {
                    WebDriverManager.firefoxdriver().setup();
                    firefoxOptions.addArguments(Arrays.asList("--headless", "--dosan-gpu"));
                    firefoxOptions.addArguments("window-size=1920,1080");
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().deleteAllCookies();
                    Log.info("Firefox Browser has been opened");
                }
            }
        }

    public static void teardown () {
        driver.close();
        try{
            driver.quit();
            Log.info("Browser already closed");
        }catch (Exception e){
            Log.info("Browser closed already, " + "did not need to quit after all");
            e.printStackTrace();
        }
    }

    }
