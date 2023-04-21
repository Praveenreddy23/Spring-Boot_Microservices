package com.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_tbl")
public class User {
    @Id
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "USER_NAME",length = 20)
    private String userName;
    @Column(name = "USER_EMAIL")
    private String userEmail;


    @Transient
    private List<Rating> ratings = new ArrayList<>();
}

