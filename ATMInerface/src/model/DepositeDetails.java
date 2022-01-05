package model;

public class DepositeDetails {
	int amount;
	int accno;
	int balance;
	public int getBalance() {
		return balance;
	}
	
	public DepositeDetails(int amount,int accno,int balance) {
		// TODO Auto-generated constructor stub
	}

    public DepositeDetails() {
		// TODO Auto-generated constructor stub
	}

	public void setBalance(int balance) {
		this.balance = balance;
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
	

}
