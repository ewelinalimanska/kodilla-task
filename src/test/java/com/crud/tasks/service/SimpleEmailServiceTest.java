package com.crud.tasks.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;

@RunWith(MockitoJUnitRunner.class)
class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

//    @Test
//    public void shouldSendEmail(){
//
//        //given
//        Mail mail = new Mail("test@test.com", "Test", "Test message", "testcc@test.com");
//
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(mail.getMailTo());
//        mailMessage.setSubject(mail.getSubject());
//        mailMessage.setText(mail.getMessage());
//        mailMessage.setCc(mail.getToCC());
//
//        //when
//        simpleEmailService.send(mail);
//
//        //then
//        verify(javaMailSender, times(1)).send(mailMessage);
//        //ile razy zostanie wywołana metoda send
//    }
}