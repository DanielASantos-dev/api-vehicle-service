package br.com.daniel.application.gateway;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;

public interface DeleteVehicleGateway {
    void delete(Vehicle vehicle) throws InternalServerErrorException;
}
