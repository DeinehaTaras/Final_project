package com.entity;

import java.sql.Date;

public class User {
    private String surname;
    private String name;
    private String secondName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String login;
    private String password;
    private boolean isAdmin;
    private boolean isManager;
    private boolean isBanned;


    public User(String userSurname, String userName, String userSecondName,
                Date userDateOfBirth, String userPhoneNumber, String userLogin,
                String userPassword, boolean userIsAdmin, boolean userIsManager,
                boolean userIsBanned) {
        surname = userSurname;
        name = userName;
        secondName = userSecondName;
        dateOfBirth = userDateOfBirth;
        phoneNumber = userPhoneNumber;
        login = userLogin;
        password = userPassword;
        isAdmin = userIsAdmin;
        isManager = userIsManager;
        isBanned = userIsBanned;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isManager() {
        return isManager;
    }

    public boolean isBanned() {
        return isBanned;
    }
}
