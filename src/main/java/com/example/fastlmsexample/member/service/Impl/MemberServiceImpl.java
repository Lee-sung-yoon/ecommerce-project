package com.example.fastlmsexample.member.service.Impl;

import com.example.fastlmsexample.member.entity.Member;
import com.example.fastlmsexample.member.model.MemberInput;
import com.example.fastlmsexample.member.repository.MemberRepository;
import com.example.fastlmsexample.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    /**
     * 회원 가입(중복된 아이디가 있으면 안된다.)
     */
    @Override
    public boolean register(MemberInput parameter) {

        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());
        if (optionalMember.isPresent()) {
            return false;
        }

        Member member = new Member();
        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setUserBirth(parameter.getUserBirth());
        member.setPassword(parameter.getPassword());
        member.setPhone(parameter.getPhone());
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }
}
