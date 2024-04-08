package br.com.daniel.usecase.dto;

import br.com.daniel.core.enums.BrandEnum;

import java.time.LocalDateTime;

public record VehicleFindParam(
        String vehicleName,
        BrandEnum brand,
        Integer year,
        Boolean isSold,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
    public static VehicleFindParam vehicleFindParamFactory(String vehicleName, BrandEnum brand, Integer year, Boolean isSold, LocalDateTime startDate,
                                                           LocalDateTime endDate) {
        return new VehicleFindParam(vehicleName, brand, year, isSold, startDate, endDate);
    }
}