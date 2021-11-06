package com.MessageServer.rest.webservices.restfulwebservices.controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Format message to specific value type")
    void handleMessage_formatTheMessage_success() throws Exception {
        mockMvc.perform(get("/message-handler/{message}", "F")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Format positive input to specific value type")
    void handleMessage_formatTheMessage_error() throws Exception {
        mockMvc.perform(get("/message-handler/{message}", "-9")
                        .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("check integration test too open screen")
    void handleMessage_openScreenMessage_success() throws Exception {
        mockMvc.perform(get("/message-handler/")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("check integration with the second server ")
    void calcSum_getMessageAndCallTheProducerServer_success() throws Exception {
        mockMvc.perform(get("/message-handler/sum/{message}", "8")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }


}
