package com.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.EncryptionPassword;
import service.LoginEnp;

public class LoginJdbc {
	public boolean login(LoginEnp loginEnp) {
		Connection connection = null;
		PreparedStatement preparedStatement;
		boolean status = false;
		ResultSet resultset = null;
		connection = DaoFactory.getConnection();
		EncryptionPassword encryptionPassword = new EncryptionPassword();
		try {
			String password = encryptionPassword.Save(loginEnp.getPassword());
			preparedStatement = connection
					.prepareStatement("select email,password from userlogin where email=? and password =?");
			preparedStatement.setString(1, loginEnp.getEamil());
			preparedStatement.setString(2, password);

			resultset = preparedStatement.executeQuery();
			String email = "";

			String pass1 = "";

			while (resultset.next()) {

				email = resultset.getString(1);
				pass1 = resultset.getString(2);
			}
			String pass;
			pass = encryptionPassword.Check(pass1);
			if (email.equals(loginEnp.getEamil()) && pass.equals(loginEnp.getPassword())) {
				status = true;
				System.out.println("login final");
			}

			return status;
		} catch (SQLException e) {
			System.out.print("Login JDBC");
			return status;

		}

	}
}