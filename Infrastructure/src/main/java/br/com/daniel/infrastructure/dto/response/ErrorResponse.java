package br.com.daniel.infrastructure.dto.response;

import java.util.List;

public record ErrorResponse( String message, String code, List<ValidationError> validitions){}
