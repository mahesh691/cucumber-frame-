package com.Definition;

import org.junit.runner.RunWith;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(features=  "OrangeHRM", glue= {"com.OrangeHRMLoginTest"})
public class TestRunner {

}
