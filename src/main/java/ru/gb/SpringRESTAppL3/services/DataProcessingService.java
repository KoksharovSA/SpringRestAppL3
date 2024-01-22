package ru.gb.SpringRESTAppL3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.SpringRESTAppL3.domain.User;
import ru.gb.SpringRESTAppL3.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository userRepository;

    public List<User> sortUserByAge(List<User> userList) {
        return userList.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUserByAge(List<User> userList, int age) {
        return userList.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> userList) {
        return userList.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public void addUserToRepository(User user){
        userRepository.addUser(user);
    }

    public List<User> getUsers(){
        return userRepository.getUserList();
    }
}
