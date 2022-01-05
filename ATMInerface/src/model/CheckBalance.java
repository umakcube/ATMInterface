package model;

public class CheckBalance {
	int accno;
	int balance;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno2) {
		this.accno = accno2;
	}
	public int getBalance() {
		return balance;
	}
	public CheckBalance(int accno, int balance) {
		super();
		this.accno = accno;
		this.balance = balance;
	}
	public CheckBalance() {
		// TODO Auto-generated constructor stub
		
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
