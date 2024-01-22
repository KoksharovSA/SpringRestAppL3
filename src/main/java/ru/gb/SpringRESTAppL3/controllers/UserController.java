package ru.gb.SpringRESTAppL3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.SpringRESTAppL3.domain.User;
import ru.gb.SpringRESTAppL3.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping
    public List<User> userList(){
        return registrationService.getDataProcessingService().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        registrationService.processRegistration(user);
        return "Пользователь добавлен.";
    }

    @PostMapping("/body/{name}-{age}-{email}")
    public String userAddFromParam(@PathVariable String name, @PathVariable int age, @PathVariable String email){
        registrationService.processRegistration(new User(name, age, email));
        return "Пользователь добавлен.";
    }
}
