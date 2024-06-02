package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.entity.Person;
import ru.netology.service.Service;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public List<Person> getPerson(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    public List<Person> getAge(@RequestParam("age") int age) {
        return service.getAge(age);
    }

    @GetMapping("/name-and-surname")
    public Optional<Person> getNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getNameSurname(name, surname);
    }

    @GetMapping("/welcome")
    public String getWelcome() {
        return "Welcome";
    }
}
