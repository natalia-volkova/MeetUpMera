package appmanager;

import model.ContactData;
import model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ContactHelper extends HelperBase {

  public ContactHelper(ApplicationManager app) {
    super(app);
   }

  public void submitContactCreation() {
    click(By.xpath("//form//button[contains(@class, 'save')]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("first_name"), contactData.getFirstName());
    type(By.name("middle_name"), contactData.getMiddleName());
    type(By.name("last_name"), contactData.getLastName());
    type(By.name("phone_add"), contactData.getPhone());
    type(By.name("mail_addr_add"), contactData.geteMail());
    enterBirthday(contactData.getBirthday());
  }

  private void enterBirthday(String birthday) {


    WebElement yearList = wd.findElement(By.xpath("//span[contains(@class, 'select-year')]"));
    yearList.click();
    selectMenuItemByText(birthdayYear(birthday));
    selectMenuItemByText(birthdayYear(birthday));


  }

  private void selectMenuItemByText(String value) {
    List <WebElement> items = wd.findElements(By.xpath("//li[contains(@class, 'menu')]"));
    WebElement item = items.stream().filter(li-> li.getText().equals(value))
            .findFirst().orElse(null);
    if (item==null){
      NoSuchElementException e;
      return;
    }
    else{
      item.click();
    }
  }

  private String birthdayDay(String birthday) {

    String birthdayDay= birthday.substring(0,2);

    return  removeRedundant(birthdayDay);
  }

  private String removeRedundant(String str) {

    if (str.substring(0,1).equals("0")){
      str = str.replaceAll("0", "");
    }
    return  str;
  }


  private int birthdayMonth(String birthday) {

    String birthdayMonth= birthday.substring(3,5);
    return  Integer.valueOf(removeRedundant(birthdayMonth));
  }

  private String birthdayYear(String birthday) {

    String birthdayYear= Integer.valueOf(birthday.substring(6)).toString();
    return  birthdayYear;
  }


  public void initCreation() {
    click(By.xpath("//*[contains(@class, 'AddContact')]"));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[contains(@class, 'mail-Abook-Person')]")));
  }


  public int count() {
    return wd.findElements(By.xpath("//span[contains(@class, 'mail-AbookEntry-Contact')]")).size();
  }

  public void create(ContactData contact) throws InterruptedException {
    initCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
    Thread.sleep(5);
    refreshPage();
  }

  public ContactData getContactInfoFromEditForm(ContactData contactEdited){
    app.goTo().contactsPage();
    clickContactByEmail(contactEdited.geteMail());
    ContactData contact = infoFromEditForm();
    closeEditForm();
    return contact;
  }

  public ContactData infoFromEditForm() {


    String firstName = wd.findElement(By.name("first_name")).getAttribute("value");
    String middleName = wd.findElement(By.name("middle_name")).getAttribute("value");
    String lastName = wd.findElement(By.name("last_name")).getAttribute("value");
    String phone = wd.findElement(By.name("phone-0")).getAttribute("value");
    String email = wd.findElement(By.name("mail_addr-0")).getAttribute("value");


    return new ContactData().withFirstName(firstName).withLastName(lastName).withMiddleName(middleName)
            .withPhone(phone).withEMail(email);
  }

  private void clickContactByEmail(String value) {

    List<WebElement> items = wd.findElements(By.xpath("//span[contains(@class, 'mail-ui-Overflower')]"));
    WebElement item = items.stream().filter(span -> span.getText().equals(value))
            .findFirst().orElse(null);
    if (item == null) {
      NoSuchElementException e;
      return;
    } else {
      item.click();
      editContactFromContactDetails();


    }
  }

  private void editContactFromContactDetails() {
    wd.findElement(By.xpath("//button[contains(@class, 'abook-person-edit' )]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'edit-cancel')]")));
  }

  public void closeEditForm(){
    click(By.xpath("//button[contains(@class, 'edit-cancel')]"));
  }




  public String mergeNames(ContactData contact) {
    return Arrays.asList(contact.getFirstName(),contact.getMiddleName(), contact.getLastName())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining(" "));

  }





}
