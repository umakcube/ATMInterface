package respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.MyConnection;
import model.CheckBalance;
import model.DepositeDetails;
import model.UserDetails;
import model.WithdrawDetails;

public class LoginDetailsDaoRes {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public LoginDetailsDaoRes() throws SQLException {
		connection = MyConnection.getConnection();
		statement = connection.createStatement();
	}

	public boolean signUp(UserDetails user) throws SQLException {
		// TODO Auto-generated method stub

		int r = statement.executeUpdate("insert into userdetails values('" + user.getUsername() + "','"
				+ user.getPassword() + "','" + user.getFirstName() + "','" + user.getLastName() + "','"
				+ user.getLocation() + "','" + user.getMobileno() + "')");
		if (r == 1) {
			return true;
		} else
			return false;

	}

	public boolean signIn(UserDetails user) throws SQLException {
		// TODO Auto-generated method stub
        String tuser = user.getUsername();
		String pass = user.getPassword();
		resultSet = statement
				.executeQuery("select *from userdetails where username='" + tuser + "' and password='" + pass + "'");
		if (resultSet.next()) {
			return true;
		} else
			return false;
	}

	public boolean withdraw(int accno, int amount) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = statement.executeQuery("select *from account where accno=" + accno + "");
		while (rs.next()) {
			int balance = rs.getInt("amount");

			if (balance > 0) {

				balance = balance - amount;
			}
			int r = statement.executeUpdate("update account set amount = " + balance + " where accno=" + accno + "");
			if (r == 1)
				return true;
		}
		return false;
	}

	public boolean deposite(int accno, int amount) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = statement.executeQuery("select *from account where accno=" + accno + "");
		while (rs.next()) {
			int balance = rs.getInt("amount");
			balance = balance + amount;
			int r = statement.executeUpdate("update account set amount = " + balance + " where accno=" + accno + "");
			if (r == 1)
				return true;
		}
		return false;
	}

	public int checkbalance(int accno) throws SQLException {
		// System.out.println("*****"+accno3);
		ResultSet rs2 = statement.executeQuery("select * from account where accno=" + accno + "");
		while (rs2.next()) {
			int value = rs2.getInt("amount");

			return value;
		}
		return 0;
	}

	}	


