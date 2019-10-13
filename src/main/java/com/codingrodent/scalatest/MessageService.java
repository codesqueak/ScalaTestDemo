package com.codingrodent.scalatest;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getMessage() {
        return "Pong !";
    }
}
