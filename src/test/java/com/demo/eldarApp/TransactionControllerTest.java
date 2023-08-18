package com.demo.eldarApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTransactionRateValid() throws Exception {
        mockMvc.perform(get("/transaction/rate")
                        .param("brand", "VISA")
                        .param("amount", "100"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTransactionRateInvalidBrand() throws Exception {
        mockMvc.perform(get("/transaction/rate")
                        .param("brand", "INVALID")
                        .param("amount", "100"))
                .andExpect(status().isBadRequest());
    }
}
