package com.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.OperationsEnp;

public class UpdateJdbc {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultset = null;

	public boolean update(OperationsEnp operationsEnp) throws SQLException {
		boolean status = false;
		connection = DaoFactory.getConnection();
		preparedStatement = connection.prepareStatement(
				"UPDATE party SET firstName=?,lastname=?,address=?,city=?,zip=?,state=?,country=?,phone=? WHERE Partyid='"
						+ operationsEnp.getPratyid() + "'");
		preparedStatement.setString(1, operationsEnp.getFirstName());
		preparedStatement.setString(2, operationsEnp.getLastName());
		preparedStatement.setString(3, operationsEnp.getAddress());
		preparedStatement.setString(4, operationsEnp.getCity());
		preparedStatement.setString(5, operationsEnp.getZip());
		preparedStatement.setString(6, operationsEnp.getState());
		preparedStatement.setString(7, operationsEnp.getCountry());
		preparedStatement.setString(8, operationsEnp.getPhone());
		preparedStatement.execute();
		status = true;
		return status;
	}
}
