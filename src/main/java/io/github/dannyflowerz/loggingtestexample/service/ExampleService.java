package io.github.dannyflowerz.loggingtestexample.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExampleService {

    public void example() {
        log.warn("Catch me if you can!");
    }

}
