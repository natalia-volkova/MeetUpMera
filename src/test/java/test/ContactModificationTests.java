package test;

import model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;

public class ContactModificationTests extends TestBase{/*
@BeforeMethod
public void ensurePreconditions(){
  if (app.db().contacts().size()==0) {
    app.contact().create(new ContactData().withLastName("Last4").withHomePhone("111"), true);
    app.goTo().mainPage();
  }

}
  @Test
  public void testContactModification(){



    ContactData modifiedContact = before.iterator().next();

    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withLastName("Last2 Modified").withFirstName("First2 modified").withHomePhone("12346567").withEMail("test2@mailtest.com");
    app.goTo().mainPage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    contact= app.contact().setContactGroups(modifiedContact, contact);
    assertThat(after, equalTo(before.withModified(modifiedContact, contact)));
    verifyContactListUI();
  }*/





}
