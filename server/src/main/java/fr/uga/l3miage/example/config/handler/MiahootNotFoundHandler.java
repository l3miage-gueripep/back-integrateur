package fr.uga.l3miage.example.config.handler;


import fr.uga.l3miage.example.error.ErrorResponse;
import fr.uga.l3miage.example.error.MiahootNotFoundErrorResponse;
import fr.uga.l3miage.example.exception.rest.MiahootNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.TestEntityNotFoundRestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ConditionalOnWebApplication
@RequiredArgsConstructor
@ControllerAdvice
@Slf4j

public class MiahootNotFoundHandler {

    @ExceptionHandler(MiahootNotFoundRestException.class)
    public ResponseEntity<ErrorResponse> handle(HttpServletRequest httpServletRequest, Exception exception) {
        MiahootNotFoundRestException ex = (MiahootNotFoundRestException) exception;
        final MiahootNotFoundErrorResponse response = MiahootNotFoundErrorResponse.builder()
                .uri(httpServletRequest.getRequestURI())
                .httpStatus(ex.getHttpStatus())
                .errorMessage(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .id(ex.getId())
                .build();

        log.warn(ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(response);
    }

}
