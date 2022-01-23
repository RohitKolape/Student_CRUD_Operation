package com.student;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class Operation {

	private static String insert_student = "insert into student(student_name,student_dob,student_doj)values(?,?,?)";
	private static String update_student = "update student set student_name = ?,student_dob= ?, student_doj =? where student_no = ?";
	private static String select_all_students = "select * from student";
	private static String select_student_by_id = "select student_no,student_name,student_dob,student_doj from student where student_no = ?";
	private static String delete_student = "delete from student where student_no = ?;";
	  
	private static connect c = new connect();
	
	
	public void insertStudent(StudentInfo student) {
		
		
		try {
//			java.util.Date birthdt;
//			java.util.Date year_of_join;
			
//			birthdt = new SimpleDateFormat("yyyy-MM-dd").parse(student.getDate_of_birth().toString());
			long l = student.getDate_of_birth().getTime();
			java.sql.Date birthd = new java.sql.Date(l);
			
			
//			year_of_join = new SimpleDateFormat("yyyy-MM-dd").parse(student.getDate_of_Join());
			long l1 = student.getDateofJoin().getTime();
			java.sql.Date dateofj = new java.sql.Date(l1);
		
			
			Connection con = c.sqlret();
			PreparedStatement pst = con.prepareStatement(insert_student);
			pst.setString(1, student.getStudentname());
			pst.setDate(2, birthd);
			pst.setDate(3, dateofj);
			
			int x = pst.executeUpdate();
			if(x!=0)
			{
				System.out.print("Inserted Sucess");
			}
			else
			{
				System.out.print("insert Failed");
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	

public List<StudentInfo> selectUserById(int student_id){
		StudentInfo stud = null;
		List <StudentInfo> student = new ArrayList <> ();
	try {
		Connection con = c.sqlret();
		PreparedStatement pst = con.prepareStatement(select_student_by_id);
		pst.setInt(1, student_id);
		
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			int number = rs.getInt("student_no");
			 String name = rs.getString("student_name");
             java.util.Date dob = rs.getDate("student_dob");
            java.util.Date doj = rs.getDate("student_doj");
            stud = new StudentInfo(name,dob,doj,number);
            student.add(stud);
             
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
System.out.println("Selecting the student by id");
		return student;
}
	
public StudentInfo selectUserByIdforEdit(int student_id){
	StudentInfo stud = null;
	
try {
	Connection con = c.sqlret();
	PreparedStatement pst = con.prepareStatement(select_student_by_id);
	pst.setInt(1, student_id);
	
	
	ResultSet rs = pst.executeQuery();
	while(rs.next()) {
		int number = rs.getInt("student_no");
		 String name = rs.getString("student_name");
         java.util.Date dob = rs.getDate("student_dob");
        java.util.Date doj = rs.getDate("student_doj");
        stud = new StudentInfo(name,dob,doj,number);
        
         
	}
}catch(Exception e) {
	e.printStackTrace();
}
System.out.println("Selecting the student by id");
	return stud;
}

public List<StudentInfo> Allstudent(){
	List <StudentInfo> students = new ArrayList <> ();
	
	try {
		Connection con = c.sqlret();
		PreparedStatement pst = con.prepareStatement(select_all_students);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			
			int student_no = rs.getInt(1);
			String student_name = rs.getString(2);
			Date student_dob = rs.getDate(3);
			Date student_doj = rs.getDate(4);
//			System.out.println("inside All student method");
			//System.out.println(student_no+student_name+student_dob+student_doj);
			students.add(new StudentInfo(student_name,student_dob,student_doj,student_no));
		}		
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
	
	return students;
}


public boolean DeleteStudent(int student_id) {
	boolean rowdeleted = false;
	
	try {
		Connection con = c.sqlret();
		PreparedStatement pst = con.prepareStatement(delete_student);
		pst.setInt(1, student_id);
		rowdeleted = pst.executeUpdate()>0;
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
	
	return rowdeleted;
}
	
	
public boolean UpdateStudent(StudentInfo student) {
	boolean rowupdated = false;
	try {
		Connection con = c.sqlret();
		PreparedStatement pst = con.prepareStatement(update_student);
		
		java.util.Date birthdt;
		java.util.Date year_of_join;
		
		birthdt = new SimpleDateFormat("yyyy-MM-dd").parse(student.getDateofbirth().toString());
		long l = birthdt.getTime();
		java.sql.Date birthd = new java.sql.Date(l);
		
		year_of_join = new SimpleDateFormat("yyyy-MM-dd").parse(student.getDateofJoin().toString());
		long l1 = year_of_join.getTime();
		java.sql.Date dateofj = new java.sql.Date(l1);
		System.out.println("Inside update function");
		
		pst.setString(1,student.name);
		pst.setDate(2, birthd);
		pst.setDate(3, dateofj);
		pst.setInt(4, student.studentno);
		
		rowupdated = pst.executeUpdate()>0;
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return rowupdated;
}
	
	
	
	
}
