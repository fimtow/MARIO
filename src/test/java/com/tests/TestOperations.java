package com.tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty",
		features = "C:\\Users\\ZEUS\\eclipse-workspace\\CucumberTest\\src\\test\\java\\com\\tests",
		glue = "com.stepsdef")

public class TestOperations {
}