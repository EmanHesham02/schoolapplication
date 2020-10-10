package com.spring.schoolapplication.category;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.utils.IFeatureFileNames;
import cucumber.api.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostCategoryUtil {
    String restURL = "http://localhost:8080/Api";
    RestTemplate restTemplate = new RestTemplate();

    public CategoryDto constructCategoryData(DataTable categoryDataTable) {
        Map<String, String> categoryMap = categoryDataTable.asMaps(String.class, String.class).get(0);
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName(categoryMap.get(IFeatureFileNames.CATEGORY_NAME));
        return categoryDto;
    }

    public Response sendRequest(CategoryDto categoryDto) {
        String restRequest = restURL + "/category";
       return given().contentType("application/json").body(categoryDto).post(restRequest);

    }

}
