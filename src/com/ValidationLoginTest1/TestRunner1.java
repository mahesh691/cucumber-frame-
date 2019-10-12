package com.ValidationLoginTest1;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="login", glue= {"com.ORHRMLogin1"})
public class TestRunner1 {


}
