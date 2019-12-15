package com.cafimanager.mail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Configuration freemarkerConfig;

    public void sendSimpleMessage(Mail mail) throws MessagingException, IOException, TemplateException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

       // helper.addAttachment("cafe.png", new ClassPathResource("/static/img/cafe.png"));
        //helper.addInline("cafe", new ClassPathResource("cafe.png"));

      //  helper.addInline("cafe", new File("cafe.png"));
        
        /**
         * ok
         */
        //Resource res = new ClassPathResource("src/main/resources/cafe.png");
        //helper.addInline("cafe1", res);
        
        /**
         * not ok
         */
        //FileSystemResource file = new FileSystemResource(new File("C:/Users/123456/Pictures/Saved Pictures/cimf.png"));
        //helper.addInline("cafe1", file);
        File f =new File("aa.html");
        f.createNewFile();
        FileSystemResource file = new FileSystemResource(new File("/src/main/resources/cafe.png"));
        helper.addInline("picture", file);
        
        Template t = freemarkerConfig.getTemplate("mail.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

        helper.setTo(mail.getTo());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getFrom());
        
        
        emailSender.send(message);
        
    }

}