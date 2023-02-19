package com.example.fastlmsexample.member.service;

import com.example.fastlmsexample.member.model.MemberInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean register(MemberInput parameter);

    /**
     * uuid 에 해당하는 계정을 활성화 한다.
     */
    boolean emailAuth(String uuid);
}
