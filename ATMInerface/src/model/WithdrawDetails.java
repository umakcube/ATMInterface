package model;

public class WithdrawDetails {
	int amount;
	int accno;
	String username;
	public WithdrawDetails(int amount, int accno, String username) {
		super();
		this.amount = amount;
		this.accno = accno;
		this.username = username;
	}
	public WithdrawDetails() {
		// TODO Auto-generated constructor stub
		super();
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
