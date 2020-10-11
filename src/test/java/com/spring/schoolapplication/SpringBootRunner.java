package com.spring.schoolapplication;
import com.spring.schoolapplication.utils.DatabaseConnector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
    classes = {SchoolapplicationApplicationTests.class},
    webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringBootRunner implements InitializingBean {

  @Value("${spring.datasource.url}")
  protected String databaseURL;

  @Value("${spring.datasource.username}")
  protected String databaseUser;

  @Value("${spring.datasource.password}")
  protected String databasePassword;

  protected DatabaseConnector databaseConnector;
  protected String restURL;

  @Override
  public void afterPropertiesSet() {
    restURL = "http://localhost:8082/";
    DatabaseConnector.setConnectionValues(databaseURL, databaseUser, databasePassword);
    databaseConnector = DatabaseConnector.getInstance();
  }

}
