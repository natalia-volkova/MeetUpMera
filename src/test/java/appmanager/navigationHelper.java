package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class navigationHelper extends HelperBase{


  public navigationHelper(ApplicationManager app) {
    super(app);
  }

  public void contactsPage() {
    if (isElementPresent(By.xpath("//*[contains(@class, 'AddContact')]")))
            {
      return;
    }
    wd.findElement(By.xpath("//a[contains(@href,'#contacts') and contains(@class, 'mail-ui-Link')]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'AddContact')]")));
  }



  public void mailPage() {
    if (isElementPresent(By.xpath("//a[@href='#sent']"))){
      return;
    }
    click(By.xpath("//a[@href='#inbox']"));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#sent']")));
  }
}
