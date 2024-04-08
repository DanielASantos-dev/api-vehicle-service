package br.com.daniel.infrastructure.dto.request;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.enums.BrandEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateVehicle(
        @NotBlank
        String vehicleName,
        String urlImg,
        @NotNull
        BrandEnum brand,
        @NotNull
        Integer year,
        @NotNull
        String description,
        @NotNull
        Boolean isSold
) {

    public Vehicle toVehicle() {
        return new Vehicle(
                this.vehicleName,
                this.urlImg,
                this.brand,
                this.year,
                this.description,
                this.isSold
        );
    }
}
