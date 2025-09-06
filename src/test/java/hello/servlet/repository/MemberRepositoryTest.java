package hello.servlet.repository;

import hello.servlet.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given

        Member member = new Member("Park", 30);

        //when

        Member savedMember = memberRepository.save(member);


        //then
        Member foundedMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(foundedMember).isEqualTo(savedMember);

    }

    void findByAll(){
        //given
        MemberRepository memberRepository = MemberRepository.getInstance();
        //when
        Member member1 = new Member("Park",20);
        Member member2 = new Member("Kim", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();


        //then


        Assertions.assertThat(members.get(0)).isEqualTo(member1);
        Assertions.assertThat(members.get(1)).isEqualTo(member2);

    }




}