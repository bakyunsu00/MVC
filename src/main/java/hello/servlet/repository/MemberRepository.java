package hello.servlet.repository;


import hello.servlet.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class MemberRepository {

    private MemberRepository(){

    }

    private static final MemberRepository instance = new MemberRepository();
    private Long sequence = 0L;
    private Map<Long, Member> store = new HashMap<>();


    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;

    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());



    }

    public void clearStore() {
        store.clear();

                    }

}
