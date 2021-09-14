package com.brillio.example.firstRestServices;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FirstRestServicesApplicationTests {

	@Autowired
	MyRestController controller;

	@Autowired
	PostController controller1;
	@Autowired
	MarkDAO markDAO;

	MarkDTO mark = new MarkDTO();
	StudentDTo student = new StudentDTo();
	Student1DTO student1 = new Student1DTO();

	@Test
	public void testMarkDTO()
	{
		try{
			mark.setId("1000");
			assertEquals(mark.getId(),"1000");
			mark.setM1("1000");
			assertEquals(mark.getM1(),"1000");
			mark.setTestno("1000");
			assertEquals(mark.getTestno(),"1000");
			mark.setM2("1000");
			assertEquals(mark.getM2(),"1000");
			mark.setM3("1000");
			assertEquals(mark.getM3(),"1000");
			mark.setSid("1000");
			assertEquals(mark.getSid(),"1000");
		}catch(Exception e)
		{
			fail();
		}
	}
	@Test
	public void testStudentDTO()
	{
		try{
			student.setSid("1000");
			assertEquals(student.getSid(),"1000");
			student.setFname("1000");
			assertEquals(student.getFname(),"1000");
			student.setLname("1000");
			assertEquals(student.getLname(),"1000");
			student.setAddress("1000");
			assertEquals(student.getAddress(),"1000");
			student.setDb1("1000");
			assertEquals(student.getDb1(),"1000");

		}catch(Exception e)
		{
			fail();
		}
	}
	@Test
	public void testStudentDTO1()
	{
		try{
			student1.setSid("1000");
			assertEquals(student1.getSid(),"1000");
			student1.setFname("1000");
			assertEquals(student1.getFname(),"1000");
			student1.setLname("1000");
			assertEquals(student1.getLname(),"1000");
			student1.setAddress("1000");
			assertEquals(student1.getAddress(),"1000");
			student1.setDb1("1000");
			assertEquals(student1.getDb1(),"1000");
			mark.setSid("Sid");
			mark.setTestno("TestNo");
			mark.setId("Id");
			mark.setM1("M1");
			mark.setM2("M2");
			mark.setM3("M3");
			List<MarkDTO> markList = new ArrayList<>();
			markList.add(mark);
			student1.setMarksList(markList);
			assertEquals(student1.getMarksList(),markList);

		}catch(Exception e)
		{
			fail();
		}
	}
	@Test
	public void testDTOAvailableOrNot() {
		try {
			StudentDTo student = new StudentDTo();
		} catch (Exception e) {
			fail();
		}
	}


	@Test
	public void testDTOAvailableOrNot1() {
		try {
			StudentDTo student = new StudentDTo();
			student.getAddress();
			student.getDb1();
			student.getFname();

		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void testFindStudent()
	{
		try {
			List<StudentDTo> allStudents = controller1.findStudent();
			assertNotNull(allStudents);
		}catch(Exception e)
		{
			fail();
		}
	}

	@Test
	public void testUpdateStudent()
	{
		try {
			StudentDTo student = new StudentDTo();
			student.setSid("110");
			student.setAddress("MYSURU");
			student.setFname("Alpha");
			student.setLname("Beta");
			student.setDb1("1999-02-03");
			String resi = controller1.updateStudent(student);
			assertEquals(resi, "Data is Updated");
		}catch(Exception e)
		{
			fail();
		}
	}

	@Test
	public void testFindStudent1()
	{
		try {
			Optional<StudentDTo> student = controller1.findStudent("108");
			assertNotNull(student);
		}catch(Exception e) {
			fail();
		}
	}

	@Test
	public void testFindStudent2()
	{
		try {
			Optional<StudentDTo> student = controller1.findStudent("5000");
			assertEquals(student,Optional.empty());
		}catch(Exception e) {
			fail();
		}
	}

	@Test
	public void testController() {
		try {
			List<StudentDTo> list = controller.getStudent();
			assertNotNull(list);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testController2() {
		try {
			Optional<StudentDTo> list = controller.getAnyStudent("101");
			assertNotNull(list);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testController3() {
		try {
			Optional<StudentDTo> list = controller.getAnyStudent("54000");
			assertEquals(list, Optional.empty());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testPostContol() {
		try {
			StudentDTo student = new StudentDTo();
			student.setSid("110");
			student.setAddress("MYSIRE");
			student.setFname("Alpha");
			student.setLname("Beta");
			student.setDb1("1999-02-03");
			String resi = controller1.insertStudent(student);
			assertEquals(resi, "Data is inserted");
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testPostControlDelete() {
		try {
			StudentDTo student = new StudentDTo();
			String resi = controller1.deleteStudent("110");
			assertEquals(resi, "Data is Deleted");
		} catch (Exception e) {
			fail();

		}
	}

	@Test
	public void testFirstMethod()
	{
		try{
			String message = controller.firstMethod();
			assertEquals(message, "Welcome to Spring boot Application");
		}
		catch(Exception e)
		{
			fail();
		}
	}
	@Test
	public void testGetAnyStudentByName()
	{
		try{
			Optional<StudentDTo> result = controller.getAnyStudentByName("Karthikeya");
			assertNotNull(result);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	@Test
	public void testGetAnyStudentByFullName()
	{
		try{
			List<StudentDTo> result = controller.getAnyStudentByName("Karthikeya","Moleyar");
			assertNotNull(result);
		}
		catch(Exception e)
		{
			fail();
		}
	}

	@Test
	public void testGetAllStudentMarks()
	{
		try{
			List<Student1DTO> result = controller.getAllStudentsMarks();
			assertNotNull(result);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	@Test
	public void testGetStudentDetails()
	{
		try{
			List<String> result = controller.getStudentDetails();
			assertNotNull(result);
		}
		catch(Exception e)
		{
			fail();
		}
	}

	@Test
	public void testGeMarks()
	{
		try{
			List<List<String>> result = markDAO.getMarks();
			assertNotNull(result);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}