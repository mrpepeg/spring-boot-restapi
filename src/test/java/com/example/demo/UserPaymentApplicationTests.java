package com.example.demo;

import com.example.controller.UserPaymentController;
import com.example.model.UserPayment;
import com.example.service.UserPaymentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserPaymentController.class)
public class UserPaymentApplicationTests {
    private static final String END_POINT_PATH = "/validatePayment";
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;

//    @InjectMocks
//    private UserPayment userPayment;
    @MockBean
    private UserPaymentServiceImpl userPaymentService;;
//    @MockBean private UserPaymentService userPayment2;
//    @MockBean private UserPayment userPayment3;

    @Test
    public void validatePaymentAPI_unregistereduser() throws Exception {

            mockMvc
                    .perform(
                    MockMvcRequestBuilders
                            .post(END_POINT_PATH)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(new UserPayment(10,"Ronny","Ronny01",145000,"IDR"))
            )).andExpect(status().isNotFound()).andDo(print());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
