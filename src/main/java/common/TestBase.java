package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
  public static long PAGE_LOAD_TIMEOUT = 20;
  public static long IMPLICIT_WAIT = 20;
  public static WebDriver driver;
  public static Properties prop;
  public  static EventFiringWebDriver e_driver;
  public static WebEventListener eventListener;

  public TestBase(){
    try {
      prop = new Properties();
      FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config/config.properties");
      prop.load(ip);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void initialization(){
    String browserName = prop.getProperty("browser");

    if(browserName.equals("chrome")){
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/chromedriver.exe");
      driver = new ChromeDriver();
    }
    else if(browserName.equals("FF")){
      System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/src/main/resources/geckodriver.exe");
      driver = new FirefoxDriver();
    }


    e_driver = new EventFiringWebDriver(driver);
    // Now create object of EventListerHandler to register it with EventFiringWebDriver
    eventListener = new WebEventListener();
    e_driver.register(eventListener);
    driver = e_driver;

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    driver.get(prop.getProperty("url"));

  }









}