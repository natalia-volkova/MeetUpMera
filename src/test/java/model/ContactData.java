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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
    if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
    return eMail != null ? eMail.equals(that.eMail) : that.eMail == null;
  }

  @Override
  public int hashCode() {
    int result = lastName != null ? lastName.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", middleName='" + middleName + '\'' +
            ", phone='" + phone + '\'' +
            ", eMail='" + eMail + '\'' +
            '}';
  }
}
