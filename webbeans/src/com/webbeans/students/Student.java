package com.webbeans.students;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements java.io.Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "STUDENTID")
  private long studentId;
  
  @Column(name = "STUDENTNAME")
  private String studentName;
  
  @Column(name="Father's Name")
  private String fathersName;
  
  @Column(name="Mother's Name")
  private String mothersName;
  
  @Column(name="Enrollment Number")
  private long enrollmentNumber;
  
  @Column(name="Address")
  private String address;
  
  @Column(name="Date Of Birth")
  private String dateOfBirth;

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

  public long getStudentId() {
    return studentId;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentName() {
    return studentName;
  }
  
  public void setFathersName(String fathersName) {
	  this.fathersName = fathersName; 
  }
  
  public String getFathersName() {
	  return fathersName;
  }
  
  public void setMothersName(String mothersName) {
	  this.mothersName = mothersName;
  }
  
  public String getMothersName() {
	  return mothersName;
  }
  
  public void setENrollmentNumber(long enrollmentNumber) {
	  this.enrollmentNumber = enrollmentNumber;
  }
  
  public long getEnrollmentNumber() {
	  return enrollmentNumber;
  }

  public void setDateOfBirth(String dateOfBirth) {
	  this.dateOfBirth = dateOfBirth;
  }
  
  public String getDateOfBirth() {
	  return dateOfBirth;
  }
  
  public void setAddress(String address){
	  this.address = address;
  }
  
  public String getAddress() {
	  return address;
  }
}



















//package com.webbeans.students;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class Student
// */
//@WebServlet("/Student")
//public class Student extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Student() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//        PrintWriter printWriter  = response.getWriter();
//        printWriter.println("<h1>Hello Students!</h1>");
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//}
