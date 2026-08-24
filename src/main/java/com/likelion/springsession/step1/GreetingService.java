package com.likelion.springsession.step1;

// 어노테이션이 하나도 없다 = 이 클래스는 Spring이 전혀 모르는 그냥 자바 객체다.
// 컨테이너에 등록되지 않으므로, 필요한 쪽이 직접 new 해서 써야 한다.
public class GreetingService {

    public String greet(String name) {
        return "안녕하세요, " + name + "님!";
    }
}
