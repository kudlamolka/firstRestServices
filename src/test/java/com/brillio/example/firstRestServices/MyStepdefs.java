package com.brillio.example.firstRestServices;

import com.brillio.example.firstRestServices.CucumberSpringConfiguration;
import com.brillio.example.firstRestServices.PostController;
import com.brillio.example.firstRestServices.StudentDTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class MyStepdefs extends CucumberSpringConfiguration {
    @Autowired
    PostController controller;

    StudentDTo student;
    StudentDTo student1;
    String result;

    @Given("A student enrolls")
    public void aStudentEnrolls() {
        student = new StudentDTo();
    }

    @When("The data is collected")
    public void theDataIsCollected() {
        student.setSid("111");
        student.setFname("Aprameya");
        student.setLname("Swaroop");
        student.setAddress("nowhere, 123");
        student.setDb1("1991-05-05");
        result = controller.insertStudent(student);
    }

    @Then("Data is added in the database")
    public void dataIsAddedInTheDatabase() {
        assertEquals(result,"Data is inserted");
    }

    @Given("A student leaves")
    public void aStudentLeaves() {
        student1 = new StudentDTo();
    }

    @When("The student data is removed")
    public void theStudentDataIsRemoved() {
        result = controller.deleteStudent("111");
    }

    @Then("Checked if data is removed")
    public void checkedIfDataIsRemoved() {
        assertEquals(result,"Data is Deleted");
    }
}
