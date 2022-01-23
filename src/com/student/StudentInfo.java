package com.student;
import java.util.Date;
public class StudentInfo {

	protected String name;
	protected Date dateofbirth;
	protected Date dateofJoin;
	protected int studentno;
	
	public StudentInfo(String name, Date dateofbirth, Date dateofJoin, int studentno) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.dateofJoin = dateofJoin;
		this.studentno = studentno;
	}

	public StudentInfo(String name, Date dateofbirth, Date dateofJoin) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.dateofJoin = dateofJoin;
	}

	public String getStudentname() {
		return name;
	}

	public void setStudentname(String name) {
		this.name = name;
	}

	public Date getDate_of_birth() {
		return dateofbirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Date getDateofJoin() {
		return dateofJoin;
	}

	public void setDateofJoin(Date dateofJoin) {
		this.dateofJoin = dateofJoin;
	}

	public int getStudentno() {
		return studentno;
	}

	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}

	
	
	
	
	

}
