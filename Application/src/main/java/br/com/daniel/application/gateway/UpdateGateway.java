package br.com.daniel.application.gateway;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;

public interface UpdateGateway {
    Vehicle update(Vehicle vehicle) throws InternalServerErrorException;
}
