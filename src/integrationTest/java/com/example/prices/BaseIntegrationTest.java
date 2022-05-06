package com.example.prices;

import com.example.prices.configuration.ControllerAdvice;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public abstract class BaseIntegrationTest {

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc =
        MockMvcBuilders.standaloneSetup(getBeans())
            .setControllerAdvice(ControllerAdvice.class)
            .build();
  }

  protected abstract Object[] getBeans();

  protected MockMvc getMockMvc() {
    return mockMvc;
  }
}
