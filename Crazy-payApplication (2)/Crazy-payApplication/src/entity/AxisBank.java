package entity;

public class AxisBank {
   private String customer_Id;// change it to String and change accordingly to the validate.java
   private String customer_Name;
   private String account_Number;
   private double amount;
   private String mobile_No;
   private String birth_Date;
public String getCustomer_Id() {
	return customer_Id;
}
public void setCustomer_Id(String customer_Id) {
	this.customer_Id = customer_Id;
}
public String getCustomer_Name() {
	return customer_Name;
}
public void setCustomer_Name(String customer_Name) {
	this.customer_Name = customer_Name;
}
public String getAccount_Number() {
	return account_Number;
}
public void setAccount_Number(String account_Number) {
	this.account_Number = account_Number;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getMobile_No() {
	return mobile_No;
}
public void setMobile_No(String mobile_No) {
	this.mobile_No = mobile_No;
}
public String getBirth_Date() {
	return birth_Date;
}
public void setBirth_Date(String birth_Date) {
	this.birth_Date = birth_Date;
}
public AxisBank(String customer_Id, String customer_Name, String account_Number, double amount, String mobile_No,
		String birth_Date) {
	super();
	this.customer_Id = customer_Id;
	this.customer_Name = customer_Name;
	this.account_Number = account_Number;
	this.amount = amount;
	this.mobile_No = mobile_No;
	this.birth_Date = birth_Date;
}
public AxisBank() {
	super();
}


}