package demo.api;

import common.RequestAPI;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pom.object.LoginDTO;

import java.util.HashMap;
import java.util.Map;

public class LoginApiTest {
  @Test
  public  void check_logi(){
    Map<String, Object> request = new HashMap<>();
    LoginDTO loginDTO = LoginDTO.builder().username("105C056630").password("12345678").build();
    Response response = RequestAPI.post("https://apipub.tcbs.com.vn/authen/v1/login", request, loginDTO);
    Assert.assertEquals("Kiem tra tra ve ma loi", 400, response.getStatusCode() );

  }
}
