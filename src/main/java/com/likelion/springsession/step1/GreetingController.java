package com.likelion.springsession.step1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 1단계: 컨트롤러가 필요한 객체를 직접 new 해서 쓴다.
// 지금 당장은 문제없이 동작한다 — 하지만 GreetingService가 다른 걸 필요로 하는 순간부터
// 그 책임까지 전부 컨트롤러가 떠안게 된다. (step2에서 바로 이 문제가 터진다)
//
// 빈 이름을 명시한 이유: step1~step3의 컨트롤러가 전부 클래스 이름이 같아서(GreetingController),
// 이름을 지정하지 않으면 컴포넌트 스캔 시 빈 이름이 겹쳐 애플리케이션이 시작되지 않는다.
@RestController("step1GreetingController")
public class GreetingController {

    private final GreetingService greetingService = new GreetingService();

    @GetMapping("/step1/greet")
    public String greet(@RequestParam String name) {
        return greetingService.greet(name);
    }
}
