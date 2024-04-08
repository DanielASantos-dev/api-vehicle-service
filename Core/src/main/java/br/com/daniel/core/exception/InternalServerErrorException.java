package br.com.daniel.core.exception;

public class InternalServerErrorException extends Exception{

    private String code;

    public InternalServerErrorException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
