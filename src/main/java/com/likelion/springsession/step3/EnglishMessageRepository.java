package com.likelion.springsession.step3;

import org.springframework.stereotype.Repository;

// @Repository를 여기로 옮기고(주석 해제) 위 KoreanMessageRepository의 @Repository를
// 주석 처리하면 영어 인사말로 바뀐다 — GreetingController, GreetingService는
// 한 글자도 안 바뀐다. MessageRepository 타입 빈이 딱 하나만 스캔되도록 항상 둘 중 하나만 켜둘 것
// (둘 다 켜두면 어떤 구현체를 주입해야 할지 몰라 컨테이너가 기동을 거부한다).
@Repository
public class EnglishMessageRepository implements MessageRepository {

    @Override
    public String findGreetingFormat() {
        return "Hello, %s!";
    }
}
