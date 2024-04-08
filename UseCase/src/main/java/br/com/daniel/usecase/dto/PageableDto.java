package br.com.daniel.usecase.dto;

public record PageableDto(int pageNumber, int pageSize, String direction) {
    public static PageableDto pageableDtoFactory(Integer page, Integer size, String sort){
        return new PageableDto(page, size, sort);
    }
}