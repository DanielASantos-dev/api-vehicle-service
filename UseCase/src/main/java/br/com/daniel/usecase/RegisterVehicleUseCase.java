package br.com.daniel.usecase;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.BadRequestException;
import br.com.daniel.core.exception.InternalServerErrorException;

public interface RegisterVehicleUseCase {
    Vehicle register(Vehicle vehicle) throws BadRequestException, InternalServerErrorException;
}
