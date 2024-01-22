package ru.gb.SpringRESTAppL3.services;

import org.springframework.stereotype.Service;
import ru.gb.SpringRESTAppL3.domain.User;

@Service
public class NotificationService {
    public void notifyUser(User user){
        System.out.println("Создан новый пользователь: " + user.getName());
    }
}
