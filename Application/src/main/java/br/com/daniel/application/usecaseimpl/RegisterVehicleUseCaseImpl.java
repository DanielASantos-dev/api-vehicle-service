package br.com.daniel.application.usecaseimpl;

import br.com.daniel.application.gateway.RegisterGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.usecase.RegisterVehicleUseCase;

public class RegisterVehicleUseCaseImpl implements RegisterVehicleUseCase {
    private final RegisterGateway registerGateway;

    public RegisterVehicleUseCaseImpl(RegisterGateway registerGateway) {
        this.registerGateway = registerGateway;
    }

    @Override
    public Vehicle register(Vehicle vehicle) throws InternalServerErrorException {
        return registerGateway.register(vehicle);
    }
}
