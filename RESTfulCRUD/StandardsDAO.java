package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBConnector;
import model.Standards;

public class StandardsDAO {

	private Connection connection;
	
	public StandardsDAO(){
		connection = DBConnector.getConnection();
	}
	
	
	public void addStandards(Standards standards){
		try{
			PreparedStatement ps = connection.prepareStatement("insert into wqcs_standards(status, chemical_id, location) "
					+ "values(?, ?, ?)");
			ps.setString(1, standards.getStatus());
			ps.setString(2, standards.getChemical_id());
			ps.setString(3, standards.getLocation());
			ps.executeUpdate();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	
	}
	
	
	public void deleteStandards(String chemicalID){
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from wqcs_standards where chemical_id = ?");
      
            preparedStatement.setString(1, chemicalID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	
	public void updateStandards(Standards standards){
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update wqcs_standards set status=?, location=? where chemical_id=?");
          
            preparedStatement.setString(1, standards.getStatus());
            preparedStatement.setString(2, standards.getLocation());
            preparedStatement.setString(3, standards.getChemical_id());
            preparedStatement.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
	
	
	public List<Standards> getAllStandards(){
		List<Standards> standardsList = new ArrayList<Standards>();
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from wqcs_standards");// where rownum <= 30");
			while (rs.next()){
				Standards standards = new Standards();
				standards.setChemical_id(rs.getString("chemical_id"));
				standards.setStatus(rs.getString("status"));
				standards.setLocation(rs.getString("location"));
				standardsList.add(standards);
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return standardsList;
	}
	
	
	public Standards getStandardsByChemicalID(String chemicalID){
		Standards standards = new Standards();
		try{
			PreparedStatement ps = connection.prepareStatement("select * from wqcs_standards where chemical_id = ?");
			ps.setString(1, chemicalID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				standards.setStatus(rs.getString("status"));
				standards.setChemical_id(rs.getString("chemical_id"));
				standards.setLocation(rs.getString("location"));
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return standards;
	}
	
	public boolean checkStandardsExistsWithChemicalID(String chemicalID){
		boolean flag = false;
		try{
			PreparedStatement ps = connection.prepareStatement("select count(*) from wqcs_standards where chemical_id = ?");
			ps.setString(1, chemicalID);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				int count = rs.getInt(1);  //rs.getInt("total");
				if (count > 0) flag = true;
				else flag = false;
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return flag;
		
	}
	
}
