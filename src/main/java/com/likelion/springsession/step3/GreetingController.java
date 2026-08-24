package com.likelion.springsession.step3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 3단계: 컨트롤러는 "GreetingService가 필요하다"는 사실만 선언한다.
// 그 GreetingService를 무엇으로, 어떻게 조립할지는 전혀 몰라도 된다 — 컨테이너가 대신 조립해서 넣어준다.
// new가 코드에서 완전히 사라진 것에 주목할 것.
//
// 빈 이름을 명시한 이유: step1~step3의 컨트롤러가 전부 클래스 이름이 같아서(GreetingController),
// 이름을 지정하지 않으면 컴포넌트 스캔 시 빈 이름이 겹쳐 애플리케이션이 시작되지 않는다.
@RestController("step3GreetingController")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/step3/greet")
    public String greet(@RequestParam String name) {
        return greetingService.greet(name);
    }
}
