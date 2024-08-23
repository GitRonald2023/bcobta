package com.bcobta.bcobta.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arakelian.faker.model.Person;
import com.arakelian.faker.service.RandomPerson;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String healthCheck() {
        return "Hola Mundo";
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return RandomPerson.get().listOf(20);
    }
}
