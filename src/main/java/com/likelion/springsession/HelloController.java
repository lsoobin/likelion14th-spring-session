package com.likelion.springsession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController = @Controller + @ResponseBody.
// 반환값을 뷰 이름이 아니라 응답 본문 그대로(문자열/JSON)로 내보낸다.
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring!";
    }

    // Jackson이 record를 자동으로 JSON으로 직렬화해준다.
    // record의 각 컴포넌트(message, code)가 그대로 JSON 필드가 된다.
    @GetMapping("/hello-json")
    public HelloResponse helloJson() {
        return new HelloResponse("Hello, Spring!", 200);
    }
}
