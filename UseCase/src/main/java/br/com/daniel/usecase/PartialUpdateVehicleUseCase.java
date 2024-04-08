package br.com.daniel.usecase;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;

public interface PartialUpdateVehicleUseCase {
    Vehicle update(Vehicle vehicle, Vehicle vehicleSaved) throws InternalServerErrorException;
}
