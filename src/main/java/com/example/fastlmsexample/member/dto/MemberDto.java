package com.example.fastlmsexample.member.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class MemberDto {
    String userId;
    String userName;
    String phone;
    String password;
    String userBirth;
    LocalDateTime regDt;

    boolean emailAuthYn;
    String emailAuthKey;
    LocalDateTime emailAuthDt;

    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;

    boolean adminYn;
}
