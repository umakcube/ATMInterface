package appmain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import dao.LoginDetailsDao;
import daoimpl.LoginDetailsDaoImpl;
import model.CheckBalance;
import model.DepositeDetails;
import model.UserDetails;
import model.WithdrawDetails;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***********Welcome to ATM Interface****************");
		System.out.println("1: Sign up");
		System.out.println("2: Sign In");

		System.out.println("3: Exit");
		System.out.println("*************************************************************");
		char ch = ' ';
		LoginDetailsDao LoginDao = new LoginDetailsDaoImpl();
		String username, firstname, lastname, password, location, mobileno;

		do {
			System.out.println("What you do wish to check from the above list");

			Scanner sn = new Scanner(System.in);
			int option = sn.nextInt();

			switch (option) {
			case 1:
				System.out.println("enter the details to signup");
				System.out.println("Enter the UserName");
				username = sn.next();
				System.out.println("Enter the Password");
				password = sn.next();
				System.out.println("Enter the FirstName");
				firstname = sn.next();
				System.out.println("Enter the LastName");
				lastname = sn.next();
				System.out.println("Enter the Location");
				location = sn.next();
				System.out.println("Enter the MobileNumber");
				mobileno = sn.next();

				UserDetails user = new UserDetails();
				user.setUsername(username);
				user.setPassword(password);
				user.setFirstName(firstname);

				user.setLastName(lastname);

				user.setLocation(location);
				user.setMobileno(mobileno);

				LoginDao.signUp(user);

				/*
				 * create table userdetails( username varchar(20) primary key,
				 * password varchar(20) not null, firstname varchar(20) not
				 * null, lastname varchar(20), location varchar(20), mobileno
				 * varchar(10) not null )
				 */

				break;
			case 2:
				System.out.println("Enter the username and password to login");
				System.out.println("Enter the Username");
				String usern = sn.next();
				System.out.println("Enter the Password");
				String pass = sn.next();
				UserDetails details = new UserDetails();
				details.setUsername(usern);
				details.setPassword(pass);
				boolean res = LoginDao.signIn(details);
				if (res) {
					System.out.println("******login success*******");

					System.out.println("-----Please choose Which option you want to check---" + usern + "-----");
					System.out.println("1: Withdraw");
					System.out.println("2: Deposite");
					System.out.println("3: CheckBalance");
					System.out.println("4: exit");
                    System.out.println("----------------------------------------------------");
					char ch1 = ' ';

					do {
						System.out.println("What you do wish to check from the above list");

						Scanner sn1 = new Scanner(System.in);
						int option1 = sn1.nextInt();

						switch (option1) {
						case 1:
							System.out.println("Enter the Amount to withdraw");
							int amount1 = sn.nextInt();
							System.out.println("Enter the account number");

							int accno1 = sn.nextInt();
							WithdrawDetails details1 = new WithdrawDetails();
							details1.setAmount(amount1);
							details1.setAccno(accno1);
							boolean rs = LoginDao.withdraw(accno1, amount1);
							if (rs)
								System.out.println("******Withdraw success******");
							else
								System.out.println("------Withdraw failed------");
							break;

						case 2:
							System.out.println("Enter the amount to deposite");
							int amount2 = sn.nextInt();
							System.out.println("Enter the account number");

							int accno2 = sn.nextInt();
							DepositeDetails details2 = new DepositeDetails();
							details2.setAmount(amount2);
							details2.setAccno(accno2);
							boolean rs1 = LoginDao.deposite(accno2, amount2);
							if (rs1)
								System.out.println("******Deposite success******");
							else
								System.out.println("------Invalid Account Number-------");
							break;

						case 3:
							System.out.println("Enter the Account number");
							int accno3 = sn.nextInt();
                            CheckBalance details3 = new CheckBalance();
							details3.setAccno(accno3);
							System.out.println("The balance amount is" + LoginDao.checkbalance(accno3));
							break;
							
						
						case 4:
							System.exit(0);
							break;
							
						default:
							System.out.println("Enter the valid option");
						}
						System.out.println("Do you wish to check other options");
						ch = sn.next().charAt(0);

					} while (ch == 'y' || ch == 'Y');

				} else
					System.out.println("------login failed------");
				break;
			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("Enter the valid option");
			}
			System.out.println("Do you wish to check other options");
			ch = sn.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}

}
