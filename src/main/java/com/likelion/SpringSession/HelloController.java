package com.likelion.SpringSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("/hello-json")
    public HelloResponse helloJson() {
        return new HelloResponse("Hello, Spring!", 200);
    }

    // 과제(기본) 예시 답안 — 본인 이름으로 바꿔서 쓰면 됩니다.
    @GetMapping("/my-name")
    public String myName() {
        return "멋쟁이사자처럼";
    }
}
