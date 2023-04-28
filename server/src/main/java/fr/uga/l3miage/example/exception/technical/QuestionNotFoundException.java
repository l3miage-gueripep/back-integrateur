package fr.uga.l3miage.example.exception.technical;

import lombok.Getter;

@Getter
public class QuestionNotFoundException extends  Exception {
    private  final Long id;

    public QuestionNotFoundException(String message, Long id) {
        super(message);
        this.id=id;
    }

    public QuestionNotFoundException(String message, Long id, Throwable cause) {
        super(message, cause);
        this.id = id;
    }

}
