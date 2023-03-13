package com.labs.javalabs;

import org.antlr.v4.runtime.misc.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class CylinderEndpointTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cylinderShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/cylinder?"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"volume\":" + Math.PI)));
    }

    @Test
    public void cylinderShouldReturnMessage() throws Exception {
        final List<Pair<Double, Double>> testNumbersList = List.of(
                new Pair<Double, Double>(22.4, 34.),
                new Pair<Double, Double>(11.3, 1.7),
                new Pair<Double, Double>(8.2, 3.4));
        for (var testNumbersPair : testNumbersList) {
            this.mockMvc.perform(get("/cylinder?height=" + testNumbersPair.a + "&radius=" + testNumbersPair.b))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString(
                            "\"volume\":" + (Math.PI * testNumbersPair.b * testNumbersPair.b * testNumbersPair.a))));
        }

    }

    @Test
    public void cylinderShouldReturnStatus400() throws Exception {
        final List<String> testStringsList = List.of("foo", "bar", "baz", "etc");
        for (var testString : testStringsList) {
            this.mockMvc.perform(get("/cylinder?height=" + testString + "&radius=" + testString)).andDo(print())
                    .andExpect(status().isBadRequest());
        }
    }

    @Test
    public void cylinderShouldReturnStatus500() throws Exception {

        this.mockMvc
                .perform(get("/cylinder?height=" + Double.NaN + "&radius=" + Double.NEGATIVE_INFINITY))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

}
