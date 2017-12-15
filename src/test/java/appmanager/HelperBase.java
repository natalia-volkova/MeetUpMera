package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperBase {

  protected ApplicationManager app;
  protected WebDriver wd;
  WebDriverWait wait;

  //public HelperBase(WebDriver wd) {
  //  this.wd = wd;
  //}

  public HelperBase(ApplicationManager app) {
    this.app = app;
    this.wd = app.wd;
    this.wait = new WebDriverWait(wd, 25);
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }

    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void refreshPage() {

      wd.navigate().refresh();

  }





}










