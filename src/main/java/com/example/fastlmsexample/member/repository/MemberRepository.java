package com.example.fastlmsexample.member.repository;

import com.example.fastlmsexample.member.dto.MemberDto;
import com.example.fastlmsexample.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByEmailAuthKey(String emailAuthKey);
    Optional<Member> findByUserIdAndUserName(String userId, String userName);
    Optional<Member> findByResetPasswordKey(String resetPasswordKey);

}
