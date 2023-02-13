package com.labs.javalabs;

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
import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
class CylinderEndpointTests {

    private final Random random = new Random();

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
        double radius = random.nextDouble();
        double height = random.nextDouble();
        this.mockMvc.perform(get("/cylinder?height=" + height + "&radius=" + radius))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"volume\":" + (Math.PI * radius * radius * height))));
    }

    @Test
    public void cylinderShouldReturnStatus400() throws Exception {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        this.mockMvc.perform(get("/cylinder?height=" + generatedString + "&radius=" + generatedString)).andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void cylinderShouldReturnStatus500() throws Exception {

        this.mockMvc
                .perform(get("/cylinder?height=" + Double.NaN + "&radius=" + Double.NEGATIVE_INFINITY))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

}
