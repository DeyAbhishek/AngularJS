package co.prvn.eatery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.prvn.eatery.entities.PersonVO;
import co.prvn.eatery.exception.EateryException;
import co.prvn.eatery.utils.DBConnector;

public class PeopleDAO {

	/**
	 * Get All People from the database
	 * @return list of PersonVO objects
	 */
	public List<PersonVO> getAllPeople() throws EateryException{
		
		Connection conn = DBConnector.connectToDB();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PersonVO> peopleList = new ArrayList<PersonVO>();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM people");
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				PersonVO person = new PersonVO();
				person.setId(rs.getInt("ID"));
				person.setFirstName(rs.getString("FIRST_NAME"));
				person.setLastName(rs.getString("LAST_NAME"));
				person.setEmail(rs.getString("EMAIL"));
				person.setAddress1(rs.getString("ADDRESS1"));
				person.setAddress2(rs.getString("ADDRESS2"));
				person.setCity(rs.getString("CITY"));
				person.setState(rs.getString("STATE"));
				person.setZip(rs.getInt("ZIP"));
				person.setPhone(rs.getString("PHONE"));

				peopleList.add(person);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EateryException("Error: " + e.getMessage(), e.getCause());
		}
		finally {
			DBConnector.closeResources(pstmt, rs, conn);
		}
		
		return peopleList;
	}
	
	public boolean editPerson (PersonVO person){
		
		return true;
	}
	
	
	public PersonVO addPerson (PersonVO person) throws EateryException{
		
		Connection conn = DBConnector.connectToDB();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			preStmt = conn.prepareStatement("INSERT INTO people (FIRST_NAME, LAST_NAME, EMAIL, ADDRESS1, ADDRESS2, CITY, ZIP, PHONE, STATE) VALUES (?,?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			preStmt.setString(1, person.getFirstName());
			preStmt.setString(2, person.getLastName());
			preStmt.setString(3, person.getEmail());
			preStmt.setString(4, person.getAddress1());
			preStmt.setString(5, person.getAddress2());
			preStmt.setString(6, person.getCity());
			preStmt.setInt(7, person.getZip());
			preStmt.setString(8, person.getPhone());
			preStmt.setString(9, person.getState());

			preStmt.executeUpdate();	
			rs = preStmt.getGeneratedKeys();

			if (rs.next()) {
				person.setId(rs.getInt(1));
			}

		} catch (SQLException e) {
			System.err.println("Error " + e.getMessage());
			e.getStackTrace();
			throw new EateryException("Error: " + e.getMessage(), e.getCause());
		} finally {
			DBConnector.closeResources(preStmt, rs, conn);
		}

		return person;
	}
	
	public PersonVO getPerson(int personId) throws EateryException{
		
		return null;
	}
	
}
