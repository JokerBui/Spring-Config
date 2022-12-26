package com.example.baitap5.service;
import com.example.baitap5.user.repository.IUserRepository;
import com.example.baitap5.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository repo;

    public List<User> listAll(){
        return repo.findAll();
    }
    public User save(User user){

        User newUser = repo.save(user);
        return newUser;
    }
    public User update(Integer id, User user) throws Exception {
        User user1 = repo.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1 = repo.save(user1);
        return user1;
    }
    public User delete(Integer id ) throws Exception {
        repo.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));
        repo.deleteById(id);
        return null;

    }
    public Optional<User> listAllById(Integer id) throws Exception {

        repo.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));
        return repo.findById(id);
    }
}
