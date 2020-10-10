package com.spring.schoolapplication.category;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/post_category.feature"},
        glue = {"com.spring.schoolapplication.category"},
        strict = true)
public class PostCategoryCucumberRunner {

    @Test
    public void test() {
    }
}
