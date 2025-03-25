package com.example.sb0319;

import com.example.sb0319.entity.Memo;
import com.example.sb0319.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@Transactional
class Sb0319ApplicationTests {

    @Autowired
    private MemoRepository memoRepository;

    @Test
    void MemoADD() {
        Memo memo = Memo.builder()
                        .content("테스트")
                                .build();
        memoRepository.save(memo);
        assertThat(1==1).isTrue();
    }
    @Test
    void contextLoads() {
    }

}
