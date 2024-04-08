package br.com.daniel.usecase;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.NotFoundException;

public interface FindVehicleByIdUseCase {
    Vehicle findById(Long id) throws NotFoundException;

}
