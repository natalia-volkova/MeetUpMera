package test;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import model.ContactData;
import model.Contacts;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import java.util.List;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {




  @DataProvider
  public Iterator<Object []> validContactsXml () throws IOException {

  try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
    String xml = "";
    String line = reader.readLine();
    while (line!=null){
      xml+=line;
      line= reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
    return contacts.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }



  }

  @DataProvider
  public Iterator<Object []> validContactsJson () throws IOException {
  try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))){
    String json = "";
    String line = reader.readLine();
    while (line!=null){
      json+=line;
      line= reader.readLine();
    }
    Gson gson = new Gson();

    List<ContactData> contacts = (List<ContactData>) gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
    return contacts.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }



  }

  @Test(dataProvider = "validContactsJson")
  public void testContactCreation(ContactData contact) throws InterruptedException {


    app.goTo().contactsPage();
    int sizeBefore = app.contact().count();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(sizeBefore+1));
    System.out.println("Contact created: "+contact);
    assertThat(app.contact().getContactInfoFromEditForm(contact), equalTo(contact));

  }

}
