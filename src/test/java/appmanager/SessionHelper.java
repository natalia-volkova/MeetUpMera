package appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase{


  public SessionHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    type(By.name("login"),username);
    type(By.name("passwd"),password);
    click(By.xpath("//button[contains(@class, 'auth')]"));

  }
}
