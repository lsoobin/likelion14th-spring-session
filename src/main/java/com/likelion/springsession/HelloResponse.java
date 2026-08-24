package com.likelion.springsession;

// record: 값을 담기만 하는 불변 객체를 짧게 선언하는 문법.
// 생성자, getter(message(), code()), equals/hashCode/toString이 자동 생성된다.
public record HelloResponse(String message, int code) {
}
