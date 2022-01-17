package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        User user1 = new User ("Anastasiya", "Gribanova", (byte)21);
        User user2 = new User ("Anastasiya2", "Gribanova2", (byte)21);
        User user3 = new User ("Anastasiya3", "Gribanova2", (byte)21);
        User user4 = new User ("Anastasiya4", "Gribanova4", (byte)21);
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

