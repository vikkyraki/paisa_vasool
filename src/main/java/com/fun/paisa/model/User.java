package com.fun.paisa.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document(value = "userInfo")
public class User {

    private static Integer UID = 1;

    //@Id
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;


    static class UserBuilder{
        private Integer id;
        private String name;
        private String email;
        private String phoneNumber;

        public Integer getId() {
            return id;
        }

        public UserBuilder setId(Integer id) {
            this.id = UID++;
            return this;
        }

        public String getName() {
            return name;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public UserBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }


    User(UserBuilder userBuilder) {
        setId(userBuilder.getId());
        setEmail(userBuilder.getEmail());
        setName(userBuilder.getName());
        setPhoneNumber(userBuilder.getPhoneNumber());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
