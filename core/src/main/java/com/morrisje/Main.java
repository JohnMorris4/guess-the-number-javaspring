package com.morrisje;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // create the context(container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator
                = context.getBean("numberGenerator", NumberGenerator.class);

//        CALL METHOD next() to get a random number
        int number = numberGenerator.next();

//        LOG generator number
        log.info("number = {}", number);

//        get the game bean from context
        Game game = context.getBean(Game.class);

        //Call the reset method
        game.reset();

//        CLOSE CONTEXT
        context.close();

    }
}
