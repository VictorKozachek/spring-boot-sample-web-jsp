package ru.schoolarlife.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.schoolarlife.mail.interfaces.MailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by victor on 14.11.16.
 */
@Service
public class MailSenderImpl implements MailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMailTo(String to, String message) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            //TODO: change to config reader
            helper.setReplyTo("someone@localhost");
            helper.setFrom("someone@localhost");
            helper.setSubject("Lorem ipsum");
            helper.setText(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        javaMailSender.send(mail);
    }
}
