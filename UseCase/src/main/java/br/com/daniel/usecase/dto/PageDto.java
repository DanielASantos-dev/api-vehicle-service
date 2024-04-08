package br.com.daniel.usecase.dto;

import java.util.List;

public record PageDto<T>(List<T> content, long totalElements, int totalPages, PageableDto pageable) {

}
