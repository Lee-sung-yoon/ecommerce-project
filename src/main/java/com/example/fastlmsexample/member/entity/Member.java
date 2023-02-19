package com.example.fastlmsexample.member.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Member {

    @Id
    private String userId;
    private String userName;
    private String userBirth;
    private String phone;
    private String password;

    private LocalDateTime regDt;

}
