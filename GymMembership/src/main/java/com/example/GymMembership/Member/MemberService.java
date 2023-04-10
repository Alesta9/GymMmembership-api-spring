package com.example.GymMembership.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired // DI
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public void addMember(Member member) {
         memberRepository.save(member);
    }

    public void deleteMemberByName(String name) {
        Optional<Member> optionalMember = memberRepository.findMemberByName(name);

        if(optionalMember.isPresent()) {
            UUID tempId = optionalMember.get().getId();
            memberRepository.deleteById(tempId);
        }
        else {
            throw new IllegalStateException("Member with name " + name + " does not exists!");
        }

    }

    public List<Member> getMemberByEmail(String email) {

        Optional<Member> optionalMember = memberRepository.findMemberByEmail(email);

        if(optionalMember.isPresent()) {
            return List.of(optionalMember.get());
        }
        else {
            throw new IllegalStateException("Member with email " + email + " does not exists!");
        }


    }
    @Transactional
    public void updateMemberEmail(UUID id, String email) {

        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "member with id " + id + " does not exists!"
        ));
        if (email.contains("@") &&
            email.length() > 5 &&
                (member.getEmail() != email)) {
            Optional<Member> optionalMember = memberRepository.findMemberByEmail(email);
            if (optionalMember.isPresent()) {
                throw new IllegalStateException("email is taken bro");
            }
            member.setEmail(email);
            System.out.println(email);

        }

    }
}
