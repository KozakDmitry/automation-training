package model;

import java.util.Objects;

public class CarRent {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String nameOnCard;
    private String cardNum;
    private String expDate;
    private String CVV;
    private String billingAddress;


    public CarRent(String name, String lastName, String email, String phone,String nameOnCard, String cardNum, String expDate, String cvv, String billingAddress) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.nameOnCard = nameOnCard;
        this.cardNum = cardNum;
        this.expDate = expDate;
        this.CVV = cvv;
        this.billingAddress = billingAddress;
    }

    public CarRent(String name, String lastName, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public CarRent(){

    }


    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }


    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getNameOnCard() {
        return nameOnCard;
    }
    public String getCardNum() {
        return cardNum;
    }
    public String getExpDate() {
        return expDate;
    }
    public String getCVV() {
        return CVV;
    }
    public String getBillingAddress() {
        return billingAddress;
    }


    @Override
    public int hashCode(){return Objects.hash(name, lastName, email, phone,nameOnCard,cardNum,expDate,CVV,billingAddress);}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRent that = (CarRent) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email)&&
                Objects.equals(phone, that.phone)&&
                Objects.equals(nameOnCard, that.nameOnCard)&&
                Objects.equals(cardNum, that.cardNum)&&
                Objects.equals(CVV, that.CVV)&&
                Objects.equals(billingAddress, that.billingAddress);
    }

    @Override
    public String toString() {
        return "carRent{" +
                "name='" + name + '\'' +
                "lastName='" + lastName + '\'' +
                ", email=" + email +
                ", phone=" + phone +
                ", nameOnCard=" + nameOnCard +
                ", cardNum=" + cardNum +
                ", CVV=" + CVV +
                ", billingAddress=" + billingAddress +
                '}';
    }






}
