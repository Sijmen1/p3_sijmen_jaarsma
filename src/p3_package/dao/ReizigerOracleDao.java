package p3_package.dao;

import java.util.ArrayList;
import java.sql.*;
import java.util.Date;

import p3_package.pojo.Reiziger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class ReizigerOracleDao extends OracleBaseDao implements ReizigerDaoInterface {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	// returns all reizigers
	@Override
	public ArrayList<Reiziger> findall() {
		// TODO Auto-generated method stub
		ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
		// opens a connection in the try statement, it automatically closes after use
		try (Connection conn = getConnection()){
		//create the statement(prepared statement not needed here considering it can't be affected from above)
		Statement stmnt= conn.createStatement();
		String s = "select * from REIZIGER";
		ResultSet rs = stmnt.executeQuery(s);
		
		while(rs.next()) {
			//fill in all the reizigers
			//set the OV_chipcards with this later
			Ov_ChipkaartOracleDao d = new Ov_ChipkaartOracleDao();
			Reiziger r1 = new Reiziger();
			r1.setReizigerid(rs.getInt("REIZIGERID"));
			r1.setVoorletters(rs.getString("VOORLETTERS"));
			r1.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
			r1.setGeboorteDatum(rs.getDate("GEBORTEDATUM"));
			r1.setAchternaam(rs.getString("ACHTERNAAM"));
			// add the OV_chipcards to the Reiziger object calls to a diffrent dao 
			//we use the reiziger object to prevent loops and set a nicer connection to begin with.
			r1.setOvC(d.findByReiziger(r1));
			reizigers.add(r1);
			
			
			
			
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return reizigers;
	}
	//get all data from one reiziger
	public Reiziger findById(int id) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
		// opens a connection in the try statement, it automatically closes after use
		try (Connection conn = getConnection()){
		// create a prepared Statement.
		String sql = "select * from REIZIGER where reizigerid = ?";
		PreparedStatement stmnt= conn.prepareStatement(sql);
		stmnt.setInt(1, id);

		rs = stmnt.executeQuery();
		
		//read out the information from the resultselt
		while(rs.next()) {
			//set the single reiziger this returns
			Ov_ChipkaartOracleDao d = new Ov_ChipkaartOracleDao();
			Reiziger r1 = new Reiziger();
			r1.setReizigerid(rs.getInt("REIZIGERID"));
			r1.setVoorletters(rs.getString("VOORLETTERS"));
			r1.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
			r1.setGeboorteDatum(rs.getDate("GEBORTEDATUM"));
			r1.setAchternaam(rs.getString("ACHTERNAAM"));
			r1.setOvC(d.findByReiziger(r1));
			//return the reiziger
			return r1;
			
			
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		//if an error occurs or the resultset is empty, it is null
		return null;
		
	}

	@Override
	public ArrayList<Reiziger> findByGBdatum(String gbDatum) {
		// TODO Auto-generated method stub
		// finds all reizigers with a birth date.
		java.util.Date date=null;
		try {
			// creates the string into a date format day(2 long) - month(2 long) - year(4 long)
			date = sdf.parse(gbDatum);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// convert to sql date
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		System.out.println(sqlDate);
		// create arraylist
		ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
		
		try (Connection conn = getConnection()){
		//create the prepared statement
		String s = "select * from reiziger where gebortedatum = ?";
		PreparedStatement stmnt= conn.prepareStatement(s);
		stmnt.setDate(1,sqlDate);
		ResultSet rs = stmnt.executeQuery();
		// get the results
		while(rs.next()) {
			//returns the gebruiker with all ov Chipcards
			Ov_ChipkaartOracleDao d = new Ov_ChipkaartOracleDao();
			Reiziger r1 = new Reiziger();
			r1.setReizigerid(rs.getInt("REIZIGERID"));
			r1.setVoorletters(rs.getString("VOORLETTERS"));
			r1.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
			r1.setGeboorteDatum(rs.getDate("GEBORTEDATUM"));
			r1.setAchternaam(rs.getString("ACHTERNAAM"));
			r1.setOvC(d.findByReiziger(r1));
			reizigers.add(r1);
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeConnection();
		return reizigers;
	}

	@Override
	public Reiziger save(Reiziger r) {
		// TODO Auto-generated method stub
		Connection conn= getConnection();
		try {
			String sql = "insert into reiziger(voorletters,tussenvoegsel,achternaam,gebortedatum) values(?,?,?,?)";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, r.getVoorletters());
			stmnt.setString(2, r.getTussenvoegsel());
			stmnt.setString(3, r.getAchternaam());
			stmnt.setDate(4, new java.sql.Date(r.getGeboorteDatum().getTime()));
			stmnt.executeQuery();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		closeConnection();
		return r;
	}

	@Override
	//updates reiziger information
	public Reiziger update(Reiziger r) {
		// TODO Auto-generated method stub
		Connection conn= getConnection();
		try {
			//create the prepared statement
			String sql = "update reiziger "
					+ "set voorletters = ?, tussenvoegsel =  ?, achternaam = ?, gebortedatum = ? "
					+ "where reizigerid = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, r.getVoorletters());
			stmnt.setString(2, r.getTussenvoegsel());
			stmnt.setString(3, r.getAchternaam());
			stmnt.setDate(4, new java.sql.Date(r.getGeboorteDatum().getTime()));
			stmnt.setInt(5, r.getReizigerid());
			stmnt.executeQuery();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			//returns null if an error occurs so you know something went wrong
			return null;
			
		}
		closeConnection();
		//returns the reiziger if you want to add it to a list because you used a cloned object.
		return r;
	}

	@Override
	public boolean delete(Reiziger r) {
		// TODO Auto-generated method stub
		//deletes reiziger if nothing is dependand on him
		
		boolean b  = false;
		
		try(Connection conn = getConnection();) {
			//prepare statement and execute
			String sql = "delete from REIZIGER where REIZIGERid = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, r.getReizigerid());
			stmnt.execute();
			//returns true if succesful
			b=true;
		}
		// this will happen quite often as users almost always have at least one card
		catch(SQLException e ) {
			e.printStackTrace();
		}
		return b;
	}

	
}
