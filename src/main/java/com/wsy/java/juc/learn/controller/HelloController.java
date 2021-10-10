package com.wsy.java.juc.learn.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    private RateLimiter rateLimiter = RateLimiter.create(2);



}
