package com.example.GymMembership.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {

    @Query("SELECT m FROM Member m WHERE m.email = ?1")
    Optional<Member> findByEmail(String email);


    @Query("SELECT m FROM Member m WHERE m.name = ?1")
    Optional<Member> findMemberByName(String name);

    @Query("SELECT m FROM Member m WHERE m.email = ?1")
    Optional<Member> findMemberByEmail(String email);
}
