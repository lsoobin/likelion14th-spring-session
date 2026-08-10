package com.likelion.SpringSession;

import org.springframework.stereotype.Repository;

@Repository
public class KoreanMessageRepository implements MessageRepository {

    @Override
    public String findGreetingFormat() {
        return "안녕하세요, %s님!";
    }
}
