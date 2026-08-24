package com.likelion.springsession.step3;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final MessageRepository messageRepository;

    // 생성자가 하나뿐이면 @Autowired를 생략해도 Spring이 자동으로 이 생성자를 통해
    // 의존성을 주입해준다. (생성자가 여러 개라면 어느 걸 쓸지 명시하기 위해 @Autowired가 필요하다)
    public GreetingService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String greet(String name) {
        String format = messageRepository.findGreetingFormat();
        return format.replace("%s", name);
    }
}
