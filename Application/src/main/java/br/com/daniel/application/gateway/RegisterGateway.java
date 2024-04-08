package br.com.daniel.application.gateway;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;

public interface RegisterGateway {
    Vehicle register(Vehicle vehicle) throws InternalServerErrorException;
}
