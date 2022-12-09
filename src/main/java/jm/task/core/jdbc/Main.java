package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Anastasiya1", "Gribanova1", (byte)21);
        userService.saveUser("Anastasiya2", "Gribanova2", (byte)21);
        userService.saveUser("Anastasiya3", "Gribanova3", (byte)21);
        userService.saveUser("Anastasiya4", "Gribanova4", (byte)21);
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

