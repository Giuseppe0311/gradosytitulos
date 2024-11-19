package com.posgrado.gradosytitulos.utils.email;

import jakarta.mail.MessagingException;

public interface IEmailService {
    void sendEmail(EmailDTO emailDTO) throws MessagingException;
}
