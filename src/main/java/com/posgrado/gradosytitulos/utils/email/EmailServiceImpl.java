package com.posgrado.gradosytitulos.utils.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements IEmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Override
    public void sendEmail(EmailDTO emailDTO) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(emailDTO.to());
        helper.setSubject(emailDTO.subject());
        //Procesamos el template
        Context context = new Context();
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", emailDTO.name());
        variables.put("message", emailDTO.message());
        context.setVariables(variables);
        String html = templateEngine.process(emailDTO.template(), context);
        ////Fin del procesamiento
        if (emailDTO.file() != null) {
            helper.addAttachment(Objects.requireNonNull(emailDTO.file().getOriginalFilename()), emailDTO.file());
        }
        helper.setText(html, true);
        javaMailSender.send(message);
    }
}
