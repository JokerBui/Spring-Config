package com.example.baitap5.model;

import com.example.baitap5.sach.entity.Sach;
import com.example.baitap5.user.entity.User;

import java.util.List;

public class Response {
    List<User> users;
    List<Sach> saches;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Sach> getSaches() {
        return saches;
    }

    public void setSaches(List<Sach> saches) {
        this.saches = saches;
    }
}
