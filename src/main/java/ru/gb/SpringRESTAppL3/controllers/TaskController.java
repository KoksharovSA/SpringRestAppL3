package ru.gb.SpringRESTAppL3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.SpringRESTAppL3.domain.User;
import ru.gb.SpringRESTAppL3.services.RegistrationService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge(){
        return registrationService.getDataProcessingService()
                .sortUserByAge(registrationService.getDataProcessingService().getUsers());
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsesByAge(@PathVariable int age){
        return registrationService.getDataProcessingService()
                .filterUserByAge(registrationService.getDataProcessingService().getUsers(), age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge(){
        return registrationService.getDataProcessingService()
                .calculateAverageAge(registrationService.getDataProcessingService().getUsers());
    }
}
