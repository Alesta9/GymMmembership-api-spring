package com.example.GymMembership.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/gym")
public class MemberController {

    private final MemberService memberService;

    @Autowired // DI
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping(path = "/members")
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping(path = "/members/{email}")
    public List<Member> getMemberByEmail(@PathVariable("email") String email) {
        return memberService.getMemberByEmail(email);
    }

    @PostMapping
    public void addMember(@RequestBody Member member) {
         memberService.addMember(member);

    }

    @DeleteMapping(path = "{name}") // localhost:8080/api/gym/meric
    public void deleteMemberByName(@PathVariable("name") String name) {
        memberService.deleteMemberByName(name);
    }

    @PutMapping(path = "{id}") // localhost:8080/api/gym/UUID
    public void updateMemberEmail(
            @PathVariable("id")UUID id,
            @RequestParam String email) {
        memberService.updateMemberEmail(id,email);
    }




}
