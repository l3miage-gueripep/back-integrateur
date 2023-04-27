package fr.uga.l3miage.example.exception.technical;

import lombok.Getter;

@Getter
public class MiahootNotFoundException extends Exception {
    private final Long id;

    public MiahootNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public MiahootNotFoundException(String message, Long id, Throwable cause) {
        super(message, cause);
        this.id = id;
    }
}
