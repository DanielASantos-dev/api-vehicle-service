package br.com.daniel.core.exception.enums;

public enum ErrorCodeEnum {
    TT0001("There was an error in creating the vehicle", "TT-0001"),
    TT0002("No vehicle found", "TT-0002"),
    TT0003("Invalid Request", "TT-0003"),
    TT0004("Issue with processing the JSON of the request", "TT-0004")

    ;
    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
