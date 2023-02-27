package com.labs.javalabs.endpoints.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.javalabs.endpoints.counter.data.Counter;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private final CounterRequests counter;

    public CounterController(CounterRequests counter) {
        this.counter = counter;
    }

    @GetMapping
    public Counter counter() {
        return new Counter(counter.counter());
    }
}
