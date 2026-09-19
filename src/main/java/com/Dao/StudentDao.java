package com.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.databasesClasses.Student;
public class StudentDao {
	Connection con;
	public StudentDao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentSms","root","gnani@123");

	}
	public boolean haveStudent(String srn) throws SQLException {
		String query="select * from student where srn=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, srn);
		ResultSet res=st.executeQuery();
		boolean exists = res.next();

	    res.close();
	    st.close();

	    return exists;
	}
	public List<Student> getStudents(String userName) throws SQLException{
		String query="select * from student where userName=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, userName);
		ResultSet res=st.executeQuery();
		List<Student> list=new ArrayList<>();
		while(res.next()) {
			Student s=new Student(res.getString(1),res.getString(2),res.getString(3),
					res.getInt(4),res.getString(5),res.getString(6));
			list.add(s);
		}
		System.out.println("done");
		System.out.println(list);
		return list;
	}
	public Student getStudentBySrn(String srn,String userName) throws SQLException {
		String query="select * from student where srn=? and userName=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, srn);
		st.setString(2, userName);
		ResultSet res=st.executeQuery();
		if(res.next()) {
		Student student=new Student(res.getString(1),res.getString(2),res.getString(3),
				res.getInt(4),res.getString(5),res.getString(6));
		return student;
		}
		return null;
	}
	public boolean haveStudent(String srn,String username) throws SQLException {
		String query="select * from student where srn=? and userName=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, srn);
		st.setString(2, username);
		ResultSet res=st.executeQuery();
		boolean exists = res.next();

	    res.close();
	    st.close();

	    return exists;
	}
	public int countStudents(String userName) throws SQLException {
		String query="select count(srn) from student where userName=? group by userName";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, userName);
		 ResultSet res=st.executeQuery();
		    res.next();
		    int value=res.getInt(1);
		    res.close();
		    st.close();
		    return value;
	}
	public void insertStudent(Student student) throws SQLException {
		String query="insert into student values(?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, student.getSrn());
		st.setString(2, student.getFirstName());
		st.setString(3, student.getLastName());
		st.setInt(4, student.getAge());
		st.setString(5, student.getBranch());
		st.setString(6, student.getUserName());
		int row=st.executeUpdate();
		st.close();
	}
	public void DeleteStudent(String srn,String userName) throws SQLException {
		String query="delete from student where srn=? and userName=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, srn);
		st.setString(2, userName);
		 int row =st.executeUpdate();
	    st.close();
	}
	public void updateStudent(Student student) throws SQLException {
		String query="update student set FirstName=?, LastName=?,age=?,branch=? where srn=? and userName=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, student.getFirstName());
		st.setString(2,student.getLastName() );
		st.setInt(3, student.getAge());
		st.setString(4, student.getBranch());
		st.setString(5, student.getSrn());
		st.setString(6, student.getUserName());
		int row=st.executeUpdate();
		System.out.println(row);
		st.close();
		System.out.println("updated row");
	
	}
}
