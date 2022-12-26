package com.example.baitap5.service;

import com.example.baitap5.sach.repository.ISachRepository;
import com.example.baitap5.sach.entity.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SachService {
    @Autowired
    private ISachRepository repo;

    public List<Sach> listAll(){
        return repo.findAll();
    }
    public Sach save(Sach sach){

        Sach newBook = repo.save(sach);
        return newBook;
    }
    public Sach update(Integer id, Sach sach) throws Exception {
        Sach sach1 = repo.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));
        sach1.setTacgia(sach.getTacgia());
        sach1.setChuyenmuc(sach.getChuyenmuc());
        sach1.setTen(sach.getTen());
        sach1 = repo.save(sach1);
        return sach1;
    }
    public Sach delete(Integer id ) throws Exception {
        repo.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));
        repo.deleteById(id);
        return null;

    }
    public Optional<Sach> listAllById(Integer id) throws Exception {

        repo.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));
        return repo.findById(id);


    }
}
