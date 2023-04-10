package com.example.GymMembership.Member;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Configuration
public class MemberConfig {

    @Bean
    CommandLineRunner commandLineRunner(MemberRepository repository) {
        return args -> {
                    Member ugur = new Member(
                            UUID.randomUUID(),
                            "ugur",
                            "uur.dogan@",
                            "male",
                            LocalDate.of(2001, Month.AUGUST,16)
                    );
                    Member meric = new Member(
                            UUID.randomUUID(),
                            "meric",
                            "meric.dogan@",
                            "male",
                            LocalDate.of(2014,Month.DECEMBER,21)
                    );
                    repository.saveAll(List.of(ugur,meric));
        };

    }





}
