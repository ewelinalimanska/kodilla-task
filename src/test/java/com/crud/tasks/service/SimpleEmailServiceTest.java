package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService = new SimpleEmailService();

    @Mock
    private JavaMailSender javaMailSender;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSendEmail(){

        //given
        Mail mail = new Mail("test@test.com", "Test", "Test message"); //"testcc@test.com");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
//        mailMessage.setCc(mail.getToCC());

        //when
        simpleEmailService.send(mail);

        //then
        verify(javaMailSender, times(1)).send(mailMessage);
        //ile razy zostanie wywołana metoda send
    }
}