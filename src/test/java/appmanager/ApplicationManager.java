package appmanager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final Properties properties;
  WebDriver wd;

  private navigationHelper navigationHelper;

  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private String browser;


  public ApplicationManager(String browser)  {

    this.browser = browser;
    properties = new Properties();
  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    }
    else if (browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }
    else if (browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));

    navigationHelper = new navigationHelper(this);
    sessionHelper = new SessionHelper(this);
    contactHelper = new ContactHelper(this);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }


  public void stop() {
    wd.quit();
  }



  public navigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }

  public byte[] takeScreenshot() {
    return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
  }


}
