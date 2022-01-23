package com.student;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student
 */
@WebServlet("/")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Operation operation;

	public void init() {
		operation = new Operation();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
//	PrintWriter out = response.getWriter();

		System.out.println(request.getServletPath());
		System.out.println("Main Path: "+request.getContextPath());
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/insert":
				insertStudent(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;
			case "/selectUserById":
				SelectUserById(request, response);
				break;
			default:
				listStudent(request, response);
				break;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println("Finish");

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException {

		java.util.Date birthdt;
		java.util.Date year_of_join;

		String name = request.getParameter("name");
		String birthdate = request.getParameter("dob");
		String dateofjoin = request.getParameter("doj");

		birthdt = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
		long l = birthdt.getTime();
		java.sql.Date birthd = new java.sql.Date(l);

		year_of_join = new SimpleDateFormat("yyyy-MM-dd").parse(dateofjoin);
		long l1 = year_of_join.getTime();
		java.sql.Date dateofj = new java.sql.Date(l1);

		StudentInfo student = new StudentInfo(name, birthd, dateofj);
		operation.insertStudent(student);
	response.sendRedirect(request.getContextPath()+"/list");
	}

//	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ParseException {
//
//		java.util.Date birthdt;
//		java.util.Date year_of_join;
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String birthdate = request.getParameter("dob");
//		String dateofjoin = request.getParameter("doj");
//
//		birthdt = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
//		long l = birthdt.getTime();
//		java.sql.Date birthd = new java.sql.Date(l);
//
//		year_of_join = new SimpleDateFormat("yyyy-MM-dd").parse(dateofjoin);
//		long l1 = year_of_join.getTime();
//		java.sql.Date dateofj = new java.sql.Date(l1);
//
//		StudentInfo student = new StudentInfo(name, birthd, dateofj,id);
//		operation.UpdateStudent(student);
//		response.sendRedirect("Showdetails.jsp");
//	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<StudentInfo> listStudent = operation.Allstudent();
//		System.out.println(listStudent);
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Showdetails.jsp");
		// System.out.println("before forward to showdetails form");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		StudentInfo existingUser = operation.selectUserByIdforEdit(id);
		boolean flag = operation.UpdateStudent(existingUser);
		if (flag) {
			System.out.println("Student Updated");
		} else {
			System.out.println("Not updated");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Modifydetails.jsp");
		request.setAttribute("student", existingUser);
		dispatcher.forward(request, response);

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		boolean rowdeleted = operation.DeleteStudent(id);
		if (rowdeleted) {
			System.out.println("row deleted");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Modifydetails.jsp");
		dispatcher.forward(request, response);
	}

	
	private void SelectUserById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("studid"));
		System.out.println("Student Id: "+id);
		System.out.println("Inside Select_user_by_id method");
		List<StudentInfo> select_user_by_id = operation.selectUserById(id);
		System.out.println(select_user_by_id);
	RequestDispatcher dispatcher = request.getRequestDispatcher("ShowDetailsById.jsp");
	request.setAttribute("select_user_by_id", select_user_by_id);
	dispatcher.forward(request, response);
	}

}
