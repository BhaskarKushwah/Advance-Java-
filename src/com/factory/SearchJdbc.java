package com.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import service.OperationsEnp;
import service.SearchEnp;

public class SearchJdbc {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultset = null;

	public ArrayList<OperationsEnp> single(SearchEnp searchEnp) throws SQLException {

		ResultSet resultset = null;
		ArrayList<OperationsEnp> arrayList = new ArrayList<OperationsEnp>();
		try {
			connection = DaoFactory.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM party  WHERE firstName = ? or lastname =? ");
			preparedStatement.setString(1, searchEnp.getFirstName());
			preparedStatement.setString(2, searchEnp.getLastName());

			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				OperationsEnp operationsEnp = new OperationsEnp();
				operationsEnp.setFirstName(resultset.getString("firstName"));
				operationsEnp.setLastName(resultset.getString("lastname"));
				operationsEnp.setAddress(resultset.getString("address"));
				operationsEnp.setCity(resultset.getString("city"));
				operationsEnp.setZip(resultset.getString("zip"));
				operationsEnp.setState(resultset.getString("state"));
				operationsEnp.setCountry(resultset.getString("country"));
				operationsEnp.setPhone(resultset.getString("phone"));
				arrayList.add(operationsEnp);
			}
		} catch (Exception e) {
			System.out.print(resultset);
			e.printStackTrace();
		}
		return arrayList;
	}

	public ArrayList<OperationsEnp> sereahALl() {
		try {
			connection = DaoFactory.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM party");
			resultset = preparedStatement.executeQuery();
			ArrayList<OperationsEnp> list = new ArrayList<OperationsEnp>();
			while (resultset.next()) {
				OperationsEnp operationsEnp = new OperationsEnp();
				operationsEnp.setPratyid(resultset.getString("Partyid"));
				operationsEnp.setFirstName(resultset.getString("firstName"));
				operationsEnp.setLastName(resultset.getString("lastname"));
				operationsEnp.setAddress(resultset.getString("address"));
				operationsEnp.setCity(resultset.getString("city"));
				operationsEnp.setZip(resultset.getString("zip"));
				operationsEnp.setState(resultset.getString("state"));
				operationsEnp.setCountry(resultset.getString("country"));
				operationsEnp.setPhone(resultset.getString("phone"));
				list.add(operationsEnp);
			}

			return list;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	public OperationsEnp singleId(String partyid) throws SQLException {

		OperationsEnp operationsEnp = new OperationsEnp();
		ResultSet resultset = null;
		try {
			connection = DaoFactory.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM party  WHERE partyid=? ");
			preparedStatement.setString(1, partyid);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				operationsEnp.setFirstName(resultset.getString("firstName"));
				operationsEnp.setLastName(resultset.getString("lastname"));
				operationsEnp.setAddress(resultset.getString("address"));
				operationsEnp.setCity(resultset.getString("city"));
				operationsEnp.setZip(resultset.getString("zip"));
				operationsEnp.setState(resultset.getString("state"));
				operationsEnp.setCountry(resultset.getString("country"));
				operationsEnp.setPhone(resultset.getString("phone"));
				operationsEnp.setPratyid(resultset.getString("Partyid"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return operationsEnp;
	}
}
