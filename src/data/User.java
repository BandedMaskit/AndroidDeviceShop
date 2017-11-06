package data;

public class User {
	public int userid;
	public String username;
	public String password;
	public Status status;
	public String firstname;
	public String lastname;
	public String shippingadress;
	public PrefferedPayment prefferedpayment;
	public String purchaseditems;
	
	public enum PrefferedPayment {
    CreditCard, PayPal, Receipt
   }
	
	public enum Status {
		admin, user
	}
   
	public User(int id, String username, String password, Status status, String firstname, String lastname, String shippingadress, PrefferedPayment prefferedpayment, String purchaseditems) {
		this.userid = id;
		this.username = username;
		this.status = status;
		this.firstname = firstname;
		this.lastname = lastname;
		this.shippingadress = shippingadress;
		this.prefferedpayment = prefferedpayment;
		this.purchaseditems = purchaseditems;
	}

	

	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getShippingadress() {
		return shippingadress;
	}

	public void setShippingadress(String shippingadress) {
		this.shippingadress = shippingadress;
	}

	public PrefferedPayment getPrefferedpayment() {
		return prefferedpayment;
	}

	public void setPrefferedpayment(PrefferedPayment prefferedpayment) {
		this.prefferedpayment = prefferedpayment;
	}

	public String getPurchaseditems() {
		return purchaseditems;
	}

	public void setPurchaseditems(String purchaseditems) {
		this.purchaseditems = purchaseditems;
	}
}