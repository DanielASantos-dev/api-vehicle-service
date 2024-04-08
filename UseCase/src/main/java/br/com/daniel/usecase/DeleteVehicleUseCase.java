package br.com.daniel.usecase;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;

public interface DeleteVehicleUseCase {
    void delete(Vehicle vehicle) throws InternalServerErrorException;
}
