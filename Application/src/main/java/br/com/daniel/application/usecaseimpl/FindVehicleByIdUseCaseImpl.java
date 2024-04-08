package br.com.daniel.application.usecaseimpl;

import br.com.daniel.application.gateway.FindVehicleByIdGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.NotFoundException;
import br.com.daniel.usecase.FindVehicleByIdUseCase;

public class FindVehicleByIdUseCaseImpl implements FindVehicleByIdUseCase {
    final private FindVehicleByIdGateway findVehicleByIdGateway;

    public FindVehicleByIdUseCaseImpl(FindVehicleByIdGateway findVehicleByIdGateway) {
        this.findVehicleByIdGateway = findVehicleByIdGateway;
    }

    @Override
    public Vehicle findById(Long id) throws NotFoundException {
        return findVehicleByIdGateway.find(id);
    }
}
