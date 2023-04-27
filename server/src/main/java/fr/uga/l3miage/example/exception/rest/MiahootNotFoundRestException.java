package fr.uga.l3miage.example.exception.rest;

import fr.uga.l3miage.example.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MiahootNotFoundRestException extends RuntimeException{
    private final Long id;

    public MiahootNotFoundRestException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public MiahootNotFoundRestException(String message, Long id, Throwable cause) {
        super(message, cause);
        this.id = id;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public ErrorCode getErrorCode(){return ErrorCode.MIAHOOT_IS_NOT_FOUND;}
}
