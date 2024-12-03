package org.example.moviereview.repository;

import org.example.moviereview.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Test
    public void insertMembers(){
        IntStream.rangeClosed(1,100).forEach(i ->{
            Member member = Member.builder()
                    .email("r"+i+"@kopo.ac.kr")
                    .pw("1234")
                    .nickname("reviewer"+i)
                    .build();
            memberRepository.save(member);
        });
    }

    @Commit
    @Transactional
    @Test
    public void testDelteMember(){
        Long mid = 1L;
        Member member = Member.builder().mid(mid).build();

        memberRepository.deleteById(mid);
        reviewRepository.deleteByMember(member);

//        reviewRepository.deleteByMember(member);
//        memberRepository.deleteById(mid);
    }
}
