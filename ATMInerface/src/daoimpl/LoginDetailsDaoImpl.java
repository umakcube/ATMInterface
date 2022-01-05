package daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.MyConnection;
import dao.LoginDetailsDao;
import model.CheckBalance;
import model.DepositeDetails;
import model.UserDetails;

import model.WithdrawDetails;
//import respository.Account;
import respository.LoginDetailsDaoRes;

public class LoginDetailsDaoImpl implements LoginDetailsDao {

	LoginDetailsDaoRes loginDetailsDaoRes = null;

	public LoginDetailsDaoImpl() {
		try {
			loginDetailsDaoRes = new LoginDetailsDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in repository" + e.getMessage());
		}
	}

	@Override
	public boolean signUp(UserDetails user) {
		// TODO Auto-generated method stub

		try {
			return loginDetailsDaoRes.signUp(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in sign up" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean signIn(UserDetails user) {
		// TODO Auto-generated method stub
		try {
			return loginDetailsDaoRes.signIn(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean withdraw(int accno, int amount) {
		try {
			return loginDetailsDaoRes.withdraw(accno, amount);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deposite(int accno, int amount) {
		try {
			return loginDetailsDaoRes.deposite(accno, amount);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public int checkbalance(int accno3) {
		// TODO Auto-generated method stub
		try {

			return loginDetailsDaoRes.checkbalance(accno3);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;

		}
	}

}
