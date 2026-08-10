package com.likelion.SpringSession;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final MessageRepository repository;

    public GreetingService(MessageRepository repository) {
        this.repository = repository;
    }

    public String greet(String name) {
        return String.format(repository.findGreetingFormat(), name);
    }
}
