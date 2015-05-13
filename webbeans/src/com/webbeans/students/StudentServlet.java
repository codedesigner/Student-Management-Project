package com.webbeans.students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.listStudent();
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String studentName = request.getParameter("studentName");
		printWriter.println(studentName);
		
		
		//long studentid = Long.valueOf(request.getParameter("studentId")).longValue();
		
		/*if(printWriter.(long id) )
			listStudent();
		else
			getStudent();
		
		response.*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
			long studentid = Long.valueOf(request.getParameter("studentid")).longValue();
			String studentName = request.getParameter("studentName");
			String fathersName = request.getParameter("fathersName");
			String mothersName = request.getParameter("mothersName");
			long enrollmentNumber = Long.valueOf(request.getParameter("enrollmentNumber")).longValue();
			String dateOfBirth = request.getParameter("dateOfBirth");
			String address = request.getParameter("address");
		
		  try {
			  if(studentid != 0)
				  this.updateStudent(studentid, studentName, fathersName, mothersName, enrollmentNumber, dateOfBirth, address);
			  else
				  this.saveStudent(studentName, fathersName, mothersName, enrollmentNumber, dateOfBirth, address);
		    
		  } catch (Exception e) { 
			  response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println("Can not add student" + e);
		  }	
		
		  
				
	}

	public Student saveStudent(String studentName, String fathersName, String mothersName, long enrollmentNumber, String dateOfBirth, String address) {
		Student student = new Student();
		try {
			entityManager.getTransaction().begin();
			System.out.println(entityManager.getTransaction().isActive());
			student.setStudentName(studentName);
			student.setFathersName(fathersName);
			student.setMothersName(mothersName);
			student.setENrollmentNumber(enrollmentNumber);
			student.setDateOfBirth(dateOfBirth);
			student.setAddress(address);
			student = entityManager.merge(student);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return student;
	}

	public void listStudent() {
		try {
			
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Student> Students = entityManager.createQuery("from Student")
					.getResultList();
			System.out.println(entityManager.getTransaction().isActive());
			for (Iterator<Student> iterator = Students.iterator(); iterator
					.hasNext();) {
				Student student = (Student) iterator.next();
				PrintWriter printWriter = new PrintWriter(System.out);
				printWriter.println(student);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	public void updateStudent(Long studentId, String studentName, String fathersName, String mothersName, long enrollmentNumber, String dateOfBirth, String address) {
		try {
			entityManager.getTransaction().begin();
			Student student = (Student) entityManager.find(Student.class,
					studentId);
			student.setStudentName(studentName);
			student.setFathersName(fathersName);
			student.setMothersName(mothersName);
			student.setENrollmentNumber(enrollmentNumber);
			student.setDateOfBirth(dateOfBirth);
			student.setAddress(address);
			System.out.println(entityManager.getTransaction().isActive());
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	public void deleteStudent(Long studentId) {
		try {
			entityManager.getTransaction().begin();
			Student student = (Student) entityManager.find(Student.class,
					studentId);
			entityManager.remove(student);
			System.out.println(entityManager.getTransaction().isActive());
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	/*public Student getStudent() {
		long studentid = request.get
	}*/
	
	/*public void runStudents() {
	    System.out.println("After Sucessfully insertion ");
	    Student student1 = this.saveStudent("Sumith");
	    Student student2 = this.saveStudent("Anoop");
	    this.listStudent();
	    System.out.println("After Sucessfully modification ");
	    this.updateStudent(student1.getStudentId(), "Sumith Honai");
	    this.updateStudent(student2.getStudentId(), "Anoop Pavanai");
	    this.listStudent();
	    System.out.println("After Sucessfully deletion ");
	    this.deleteStudent(student2.getStudentId());
	    this.listStudent();
	  }*/
}

// }
