package com.brinkley.spring;

import org.springframework.stereotype.Component;

@Component
public class SynthMusic implements Music {
    @Override
    public String getSong() {
        return "II";
    }
}
