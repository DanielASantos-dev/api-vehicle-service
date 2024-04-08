package br.com.daniel.application.gateway;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.NotFoundException;

public interface FindVehicleByIdGateway {
    Vehicle find(Long id) throws NotFoundException;
}
