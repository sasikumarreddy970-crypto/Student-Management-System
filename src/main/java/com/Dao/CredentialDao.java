package com.Dao;
import java.sql.*;

import com.databasesClasses.Credential;
public class CredentialDao {
	
	Connection con;
	public   CredentialDao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Credentials","root","gnani@123");
	}
	public boolean haveUser(String username) throws SQLException {
		String query="select * from credentials where userName=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, username);
		ResultSet res=st.executeQuery();
		boolean exists = res.next();

	    res.close();
	    st.close();

	    return exists;
	}
	public int countUsers() throws SQLException {
		String query="select count(userName) from credentials";

	    PreparedStatement st=con.prepareStatement(query);

	    ResultSet res=st.executeQuery();
	    res.next();
	    int value=res.getInt(1);
	    res.close();
	    return value;
	}
	public String getNameByuserName(String userName) throws SQLException {

	    String query="select name from credentials where userName=?";

	    PreparedStatement st=con.prepareStatement(query);
	    st.setString(1, userName);

	    ResultSet res=st.executeQuery();

	    String name = null;

	    if(res.next()) {
	        name = res.getString("name");
	    }

	    res.close();
	    st.close();

	    return name;
	}
	public boolean checkLogin(Credential cred) throws SQLException {
		String query="select * from credentials where userName=? and password=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, cred.getUsername());
		st.setString(2, cred.getPassword());
		ResultSet res=st.executeQuery();
		boolean exists = res.next();
		
	    res.close();
	    st.close();

	    return exists;
	}
	public void createAccount(Credential cred) throws SQLException {
		String query="insert into credentials values(?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, cred.getUsername());
		st.setString(2, cred.getPassword());
		st.setString(3, cred.getName());
		st.setString(4, cred.getEmail());
		int row=st.executeUpdate();
		st.close();
	}
}
