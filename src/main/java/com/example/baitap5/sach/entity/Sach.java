package com.example.baitap5.sach.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sachs")

public class Sach implements Serializable {
    private static final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(nullable = false, name = "ten")
    private String ten;
    @Column(nullable = true, name = "chuyenmuc")
    private String chuyenmuc;
    @Column(nullable = true, name = "tacgia")
    private String tacgia;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChuyenmuc() {
        return chuyenmuc;
    }

    public void setChuyenmuc(String chuyenmuc) {
        this.chuyenmuc = chuyenmuc;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }
}
