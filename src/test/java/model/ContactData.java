package model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;



import java.io.File;


@XStreamAlias("contact")


public class ContactData {
  @XStreamOmitField

  private int id= Integer.MAX_VALUE;
  @Expose

  private  String lastName = "";
  @Expose

  private  String firstName= "";
  @Expose

  private  String middleName= "";
  @Expose

  private  String phone= "";


  @Expose

  private  String eMail= "";

  @Expose

  private  String birthday= "";








  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }


  public ContactData withMiddleName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withPhone(String phone) {
    this.phone = phone;
    return this;
  }


  public ContactData withEMail(String eMail) {
    this.eMail = eMail;
    return this;
  }

  public ContactData withBirthday(String birthday) {
    this.birthday = birthday;
    return this;
  }





  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getPhone() {
    return phone;
  }





  public String geteMail() {
    return eMail;
  }

  public String getBirthday() {
    return birthday;
  }

  public int getId() {    return id;  }





}
