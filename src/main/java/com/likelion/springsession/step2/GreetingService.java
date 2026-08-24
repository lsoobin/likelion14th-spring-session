package com.likelion.springsession.step2;

// 여전히 어노테이션이 없다. 이 클래스를 쓰려면 누군가 MessageRepository 구현체를
// 직접 만들어서 생성자에 넣어줘야 한다 — 그 "누군가"가 지금은 컨트롤러다.
public class GreetingService {

    private final MessageRepository messageRepository;

    public GreetingService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String greet(String name) {
        String format = messageRepository.findGreetingFormat();
        return format.replace("%s", name);
    }
}
