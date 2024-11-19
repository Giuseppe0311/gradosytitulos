package com.posgrado.gradosytitulos.utils.email;

import org.springframework.web.multipart.MultipartFile;

public record EmailDTO(
        String template,
        String to,
        String subject,
        String name,
        String message,
        MultipartFile file
) {
}
