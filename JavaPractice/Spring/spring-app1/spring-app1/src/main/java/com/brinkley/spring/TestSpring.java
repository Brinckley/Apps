package com.brinkley.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        //Music musicBean = context.getBean("musicBean", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(musicBean);

        MusicPlayer musicPlayerFirst = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayerSecond = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comparison = musicPlayerFirst == musicPlayerSecond;
        System.out.println(comparison + "\n");

        musicPlayerSecond.setName("New Media Player");
        musicPlayerSecond.setVolume(89);

        System.out.println("Music player1 name:  " + musicPlayerFirst.getName());
        System.out.println("Current volume1:  " + musicPlayerFirst.getVolume());
        musicPlayerFirst.playMusic();
        System.out.println();
        System.out.println("Music player2 name:  " + musicPlayerSecond.getName());
        System.out.println("Current volume2:  " + musicPlayerSecond.getVolume());
        musicPlayerSecond.playMusic();

        context.close();
    }
}
