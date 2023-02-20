package com.example.fastlmsexample.member.service;

import com.example.fastlmsexample.member.model.MemberInput;
import com.example.fastlmsexample.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean register(MemberInput parameter);

    /**
     * uuid 에 해당하는 계정을 활성화 한다.
     */
    boolean emailAuth(String uuid);

    /**
     * 입력한 이메일로 비밀번호 초기화 정보 전송
     */
    boolean sendResetPassword(ResetPasswordInput parameter);

    /**
     * 비밀번호 초기화
     * 입력받은 uuid에 대해서 비밀번호 초기화 설정
     */
    boolean resetPassword(String uuid, String password);

    /**
     * 입력 받은 uuid 값이 유효한지 확인
     */
    boolean checkResetPassword(String uuid);
}
