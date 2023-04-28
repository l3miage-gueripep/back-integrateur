package fr.uga.l3miage.example.config.handler;

import fr.uga.l3miage.example.error.ErrorResponse;
import fr.uga.l3miage.example.error.QuestionNotFoundErrorResponse;
import fr.uga.l3miage.example.exception.rest.MiahootNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.QuestionNotFoundRestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ConditionalOnWebApplication
@RequiredArgsConstructor
@ControllerAdvice
@Slf4j

public class QuestionNotFoundHandler {

    @ExceptionHandler(QuestionNotFoundRestException.class)
    public ResponseEntity<ErrorResponse> handle(HttpServletRequest httpServletRequest, Exception exception) {
        QuestionNotFoundRestException ex = (QuestionNotFoundRestException) exception;
        final QuestionNotFoundErrorResponse response = QuestionNotFoundErrorResponse.builder()
                .uri(httpServletRequest.getRequestURI())
                .httpStatus(ex.getHttpStatus())
                .errorMessage(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .id(ex.getId())
                .build();

        log.warn(ex.getMessage());
        return  ResponseEntity.status(ex.getHttpStatus()).body(response);
    }

}
