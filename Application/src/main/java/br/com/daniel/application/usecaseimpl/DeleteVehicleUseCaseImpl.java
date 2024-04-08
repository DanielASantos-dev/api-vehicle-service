package br.com.daniel.application.usecaseimpl;

import br.com.daniel.application.gateway.DeleteVehicleGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.usecase.DeleteVehicleUseCase;


public class DeleteVehicleUseCaseImpl implements DeleteVehicleUseCase {
    final private DeleteVehicleGateway deleteVehicleGateway;

    public DeleteVehicleUseCaseImpl(DeleteVehicleGateway deleteVehicleGateway) {
        this.deleteVehicleGateway = deleteVehicleGateway;
    }

    @Override
    public void delete(Vehicle vehicle) throws InternalServerErrorException {
        deleteVehicleGateway.delete(vehicle);
    }


}
