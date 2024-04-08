package br.com.daniel.infrastructure.dto.response;

public record ValidationError(String field, String message) {
}
