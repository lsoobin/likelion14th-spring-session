package com.likelion.springsession.step2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 2단계: GreetingService의 의존성이 하나 늘었을 뿐인데,
// 컨트롤러가 MessageRepository의 존재와 그 구현체까지 알아야 하는 상황이 됐다.
//
// 빈 이름을 명시한 이유: step1~step3의 컨트롤러가 전부 클래스 이름이 같아서(GreetingController),
// 이름을 지정하지 않으면 컴포넌트 스캔 시 빈 이름이 겹쳐 애플리케이션이 시작되지 않는다.
@RestController("step2GreetingController")
public class GreetingController {

    // 😫 저장소 구현을 바꾸려면(한국어 → 영어) 이 줄을 고쳐야 한다.
    // 컨트롤러는 "인사말을 조립해줘" 라고만 말하고 싶은데, 실제로는 조립 재료 조달까지 떠맡고 있다.
    private final GreetingService greetingService = new GreetingService(new KoreanMessageRepository());

    @GetMapping("/step2/greet")
    public String greet(@RequestParam String name) {
        return greetingService.greet(name);
    }
}
