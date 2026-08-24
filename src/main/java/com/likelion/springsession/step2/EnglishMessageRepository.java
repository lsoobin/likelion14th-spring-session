package com.likelion.springsession.step2;

public class EnglishMessageRepository implements MessageRepository {

    @Override
    public String findGreetingFormat() {
        return "Hello, %s!";
    }
}
