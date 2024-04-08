package br.com.daniel.application.usecaseimpl;

import br.com.daniel.application.gateway.UpdateGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.usecase.UpdateVehicleUseCase;

import java.time.LocalDateTime;

public class UpdateVehicleUseCaseImpl implements UpdateVehicleUseCase {
    final private UpdateGateway updateGateway;

    public UpdateVehicleUseCaseImpl(UpdateGateway updateGateway) {
        this.updateGateway = updateGateway;
    }

    @Override
    public Vehicle update(Vehicle vehicle, Vehicle vehicleSaved) throws InternalServerErrorException {
        vehicleSaved.setVehicleName(vehicle.getVehicleName());
        vehicleSaved.setUrlImg(vehicle.getUrlImg());
        vehicleSaved.setBrand(vehicle.getBrand());
        vehicleSaved.setDescription(vehicle.getVehicleName());
        vehicleSaved.setSold(vehicle.getSold());
        vehicleSaved.setYear(vehicle.getYear());
        vehicleSaved.setUpdatedAt(LocalDateTime.now());
        return updateGateway.update(vehicleSaved);
    }
}
