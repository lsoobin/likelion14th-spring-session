package com.likelion.springsession.step2;

public class KoreanMessageRepository implements MessageRepository {

    @Override
    public String findGreetingFormat() {
        return "안녕하세요, %s님!";
    }
}
