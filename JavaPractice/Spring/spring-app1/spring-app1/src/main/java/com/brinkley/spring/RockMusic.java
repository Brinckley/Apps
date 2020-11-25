package com.brinkley.spring;

import org.springframework.stereotype.Component;

@Component ("musicBeanSecond")
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Bleed";
    }
}
