package com.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.EncryptionPassword;
import service.RegisterEnp;

public class ResgisterJdbc {
	Connection connection = DaoFactory.getConnection();

	public boolean party(RegisterEnp registerEnp) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"insert into party(firstName,lastname,address,city,zip,state,country,phone) values(?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, registerEnp.getFirstName());
			preparedStatement.setString(2, registerEnp.getLastName());
			preparedStatement.setString(3, registerEnp.getAddress());
			preparedStatement.setString(4, registerEnp.getCity());
			preparedStatement.setString(5, registerEnp.getZip());
			preparedStatement.setString(6, registerEnp.getState());
			preparedStatement.setString(7, registerEnp.getCountry());
			preparedStatement.setString(8, registerEnp.getPhone());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		int id = partyid(registerEnp);
		boolean successful = insertUl(id, registerEnp);
		return successful;

	}

	public int partyid(RegisterEnp registerEnp) throws SQLException {
		java.sql.PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement("SELECT partyid FROM party where firstName = ?");
		preparedStatement.setString(1, registerEnp.getFirstName());
		ResultSet rs = preparedStatement.executeQuery();
		int id = 0;
		while (rs.next()) {
			id = rs.getInt(1);

		}
		return id;
	}

	public boolean insertUl(int id, RegisterEnp registerEnp) throws SQLException {
		PreparedStatement preparedStatement = null;
		EncryptionPassword encryptionPassword = new EncryptionPassword();
		boolean status;
		String password = encryptionPassword.Save(registerEnp.getPassword());
		preparedStatement = connection.prepareStatement("insert into  userlogin(email,password,partyid) values(?,?,?)");
		preparedStatement.setString(1, registerEnp.getEmail());
		preparedStatement.setString(2, password);
		preparedStatement.setInt(3, id);
		preparedStatement.execute();

		status = true;
		return status;
	}
}
