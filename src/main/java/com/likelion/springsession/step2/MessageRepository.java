package com.likelion.springsession.step2;

// 인사말 "형식"만 정의하는 인터페이스.
// GreetingService는 이 인터페이스만 알고, 실제로 어떤 구현체가 쓰이는지는 몰라야 한다.
public interface MessageRepository {

    String findGreetingFormat();
}
