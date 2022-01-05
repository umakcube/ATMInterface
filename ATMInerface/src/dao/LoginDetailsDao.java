package dao;

import model.CheckBalance;
import model.DepositeDetails;
import model.UserDetails;
import model.WithdrawDetails;

public interface LoginDetailsDao {
	public boolean signUp(UserDetails user);
	public boolean signIn(UserDetails user);
	public boolean deposite(int accno2, int amount2);
	public boolean withdraw(int accno1, int amount1);
	public int checkbalance(int accno3);
	
}
