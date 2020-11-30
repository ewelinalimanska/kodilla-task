package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminConfigTest {

    @Autowired
    private AdminConfig adminConfig;

    @Test
    public void testAdminConfig(){

        String admin = adminConfig.getAdminMail();

        assertEquals("onlytointellij@gmail.com", admin);
    }

}