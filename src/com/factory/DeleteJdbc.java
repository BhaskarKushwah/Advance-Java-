package com.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import service.OperationsEnp;

public class DeleteJdbc {
	public boolean delete(OperationsEnp operationsEnp) {
		boolean status = false;
		PreparedStatement preparedStatement, preparedStatement2;
		Connection connection = DaoFactory.getConnection();
		System.out.print(operationsEnp.getPratyid());
		String check = "SET FOREIGN_KEY_CHECKS=0";
		try {

			preparedStatement2 = connection.prepareStatement(check);
			preparedStatement2.execute();
			preparedStatement = connection.prepareStatement(
					"DELETE u, p FROM userlogin u INNER JOIN party p ON u.partyid = p.partyid WHERE u.partyId="
							+ operationsEnp.getPratyid());

			preparedStatement.execute();
			status = true;
			return status;
		} catch (SQLException e) {
			return status;
		}

	}
}
