package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Students;
import com.posgrado.gradosytitulos.repository.StudentRepository;
import com.posgrado.gradosytitulos.utils.email.EmailDTO;
import com.posgrado.gradosytitulos.utils.email.IEmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentsService extends AbstractCrudService<Students, Long> {

    private final IEmailService emailService;
    private final StudentRepository repository;

    @Override
    protected CrudRepository<Students, Long> getRepository() {
        return repository;
    }

    @Override
    public Students create(Students obj) {
        try {
            emailService.sendEmail(
                    new EmailDTO(
                            "studentregister",
                            obj.getEmail(),
                            "Registro de estudiante",
                            obj.getName(),
                            "",
                            null
                    ));

        } catch (MessagingException | RuntimeException e) {
            log.error("Hubo un error", e);
        }
        return super.create(obj);
    }
}
