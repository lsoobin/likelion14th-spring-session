package com.likelion.SpringSession;

// 영어 버전으로 바꾸고 싶다면 이 클래스에 @Repository를 붙이고
// KoreanMessageRepository 쪽 @Repository를 떼면 됩니다.
// GreetingService, GreetingController는 전혀 건드리지 않아도 동작합니다.
public class EnglishMessageRepository implements MessageRepository {

    @Override
    public String findGreetingFormat() {
        return "Hello, %s!";
    }
}
