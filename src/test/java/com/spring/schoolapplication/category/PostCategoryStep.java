package com.spring.schoolapplication.category;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.utils.DatabaseConnector;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.junit.Assert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.restassured.response.Response;

public class PostCategoryStep implements En {
    private PostCategoryUtil postCategoryUtil;
    protected DatabaseConnector databaseConnector;
    private CategoryDto categoryDto;

    public PostCategoryStep() {

        Given("^that the last category is \"([^\"]*)\"$",
                (String expectedLastId) -> {
                    PreparedStatement ps =
                            databaseConnector.createPreparedStatement(
                                    "Select id from category order by id desc limit 1");
                    ResultSet resultSet = databaseConnector.executeQuery(ps);
                    int lastId = -1;
                    if (resultSet.next()) {
                        lastId = resultSet.getInt("id");
                    }
                    Assert.assertEquals(Integer.parseInt(expectedLastId), lastId);
                });


        When("^Admin User post new category with the following value :$", (DataTable categoryDataTable) -> {
            categoryDto = postCategoryUtil.constructCategoryData(categoryDataTable);
            postCategoryUtil.sendRequest(categoryDto);

        });


        Then("^the category are added with id \"([^\"]*)\"$", (String expectedLastId) -> {
            PreparedStatement ps =
                    databaseConnector.createPreparedStatement(
                            "Select id from category order by id desc limit 1");
            ResultSet resultSet = databaseConnector.executeQuery(ps);
            int lastId = -1;
            if (resultSet.next()) {
                lastId = resultSet.getInt("id");
            }
            Assert.assertEquals(Integer.parseInt(expectedLastId), lastId);
        });

    }

    @Before
    public void setup() throws Exception {
        postCategoryUtil = new PostCategoryUtil();
        categoryDto = new CategoryDto();
        databaseConnector = DatabaseConnector.getInstance();
        databaseConnector.createConnection();
    }

    @After
    public void afterEachScenario() throws SQLException {
        databaseConnector.closeConnection();
    }


}
