package ru.gb.SpringRESTAppL3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.SpringRESTAppL3.domain.User;

@Service
public class RegistrationService {
    @Autowired
    private UserService userService;
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private NotificationService notificationService;

    public UserService getUserService() {
        return userService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }


    public void processRegistration(User user) {
        dataProcessingService.addUserToRepository(user);
        notificationService.notifyUser(user);
    }
}
