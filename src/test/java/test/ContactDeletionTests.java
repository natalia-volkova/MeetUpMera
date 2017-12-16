package test;

import model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().contactsPage();
    if (app.contact().count()==0) {

      app.contact().create(new ContactData().withFirstName("FirstDeletion").withLastName("LastDeletion").withPhone("111").withEMail("eMail@deletion.com").withBirthday("01.01.2000"));

    }
  }

    
    @Test
    public void testContactDelete() {

      int sizeBefore = app.contact().count();
      app.goTo().contactsPage();
      app.contact().delete();
      assertThat(app.contact().count(), equalTo(sizeBefore-1));

  }




}
