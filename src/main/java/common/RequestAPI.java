package common;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

public class RequestAPI {

  public static Response get(String url, Map<String, Object> request) {
    return SerenityRest.given()
        .baseUri(url)
        .headers(request)
        .queryParams(request)
        .get();
  }

  public static Response post(String url, Map<String, Object> request, Object body) {
    return SerenityRest.given()
        .baseUri(url)
        .headers(request)
        .body(body)
        .queryParams(request)
        .post();
  }

  public static Response put(String url, Map<String, Object> request, Object body) {
    return SerenityRest.given()
        .baseUri(url)
        .headers(request)
        .body(body)
        .queryParams(request)
        .put();
  }

  public static Response delete(String url, Map<String, Object> request) {
    return SerenityRest.given()
        .baseUri(url)
        .headers(request)
        .queryParams(request)
        .delete();
  }
}
