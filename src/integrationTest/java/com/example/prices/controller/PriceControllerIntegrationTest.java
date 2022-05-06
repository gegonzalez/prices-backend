package com.example.prices.controller;

import com.example.prices.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
@ActiveProfiles("integrationTest")
public class PriceControllerIntegrationTest extends BaseIntegrationTest {

  private static final String PRICES_URL = "/prices/";
  @Autowired private PriceController priceController;

  @Override
  protected Object[] getBeans() {
    return new Object[] {priceController};
  }

  @Test
  void shouldReturnNotFoundWhenPathParamsNotPresent() throws Exception {
    getMockMvc()
        .perform(get(PRICES_URL))
        .andExpect(status().isNotFound());
  }

  @ParameterizedTest
  @ValueSource(strings = {"1/35455/2020-12-14T10:00:00","1/35455/2020-12-14T16:00:00","1/35455/2020-12-14T21:00:00",
                          "1/35455/2020-12-15T10:00:00","1/35455/2020-12-16T21:00:00"})
  void shouldReturnBadRequestWhenQueryParamIsInvalid(String pathParams) throws Exception {
    getMockMvc()
        .perform(get(PRICES_URL + pathParams)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful());
  }

  @Test
  void shouldReturnNotFoundWhenPathParamsNotExists() throws Exception {
    getMockMvc()
            .perform(get(PRICES_URL + "999/999/2020-12-14T16:00:00"))
            .andExpect(status().isNotFound());
  }
}
