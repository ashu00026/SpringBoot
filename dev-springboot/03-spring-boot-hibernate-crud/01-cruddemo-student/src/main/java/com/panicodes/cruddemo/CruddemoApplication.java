package com.panicodes.cruddemo;

import com.panicodes.cruddemo.dao.StudentDAO;
import com.panicodes.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudentDetails(studentDAO);
//			getAllStudents(studentDAO);
//			getAllStudentsWithLastName(studentDAO);
//			updateStudent(studentDAO);
//			updateStudents(studentDAO);
//			delete(studentDAO);
//			deleteMultiple(studentDAO);
//			deleteAllEntries(studentDAO);

		};

	}

	private void deleteAllEntries(StudentDAO studentDAO) {
		int ans=studentDAO.deleteAll();
		System.out.println(ans);
	}

	private void deleteMultiple(StudentDAO studentDAO) {
		studentDAO.deleteMany();
		System.out.println("deleted Multiple students");
	}

	private void delete(StudentDAO studentDAO) {
		int id=3;
		studentDAO.deleteStudent(id);
		System.out.println("deleted Student of id: "+id);
	}

	private void updateStudents(StudentDAO studentDAO) {
		studentDAO.updateMultipleStudents();
//		System.out.println("updated");
		List<Student>theStudents=studentDAO.findEntries();
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		Student theStudent=studentDAO.findById(studentId);
		theStudent.setLastName("Panigrahi");
		studentDAO.updateStudent(theStudent);
		System.out.println(theStudent);
	}

	private void getAllStudentsWithLastName(StudentDAO studentDAO) {
		List<Student>theStudents=studentDAO.findEntriesWithLastName("Doe");
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student>theStudents=studentDAO.findEntries();
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudentDetails(StudentDAO studentDAO) {
		//create a student
		System.out.println("creating a student object...");
		Student tempStudent=new Student("ashutosh","panigrahi","ashutosh@gmail.com");
		//save the student
		System.out.println("saving the student into database...");
		studentDAO.save(tempStudent);
		//display the id of the student
		int theId=tempStudent.getId();
		System.out.println("the student id we are retrieving is: "+theId);

		//retrieve the student  based on the id
		Student myStudent=studentDAO.findById(theId);
		//display the student
		System.out.println("Found the Student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple Students
		System.out.println("creating 3 student Object");
		Student tempStudent1=new Student("john","Doe","johnDoe@gmail.com");
		Student tempStudent2=new Student("marry","publid","marry@gmail.com");
		Student tempStudent3=new Student("bonita","applebum","bonita@gmail.com");
		//save the student objects
		System.out.println("saving to database//");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("creating a student Object");
		Student tempStudent=new Student("paul","Doe","paulDoe@gmail.com");

		//save the student object

		System.out.println("saving the Stuudent");
		studentDAO.save((tempStudent));

		//display the id of saved student
		System.out.println("saved the student into database of id: "+tempStudent.getId()+" and name: "+tempStudent.getFirstName()+" "+tempStudent.getLastName());

	}
}
