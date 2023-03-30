package com.proshore.powerplant.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.dto.Range;
import com.proshore.powerplant.application.mapper.BatteryMapper;
import com.proshore.powerplant.application.service.BatteryService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BatteryController.class)
class BatteryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BatteryService service;
    @MockBean
    private BatteryMapper mapper;

    @Test
    @SneakyThrows
    void register_success() {
        RequestBuilder builder = MockMvcRequestBuilders
                .post("/api/v1/batteries/register")
                .contentType(APPLICATION_JSON)
                .content(jsonString(List.of(batteryRequest())));

        mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void register_badRequest() {
        RequestBuilder builder = MockMvcRequestBuilders
                .post("/api/v1/batteries/register")
                .contentType(APPLICATION_JSON)
                .content(jsonString(List.of(new BatteryRequest())));

        mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    void statistics_success() {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/api/v1/batteries/info")
                .contentType(APPLICATION_JSON)
                .content(jsonString(new Range("100", "200")));

        mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void statistics_badRequest() {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/api/v1/batteries/info")
                .contentType(APPLICATION_JSON)
                .content(jsonString(new Range()));

        mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    private String jsonString(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }

    private BatteryRequest batteryRequest() {
        var request = new BatteryRequest();
        request.setName("Cannington");
        request.setPostcode("6107");
        request.setCapacity(13500);
        return request;
    }
}