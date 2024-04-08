package br.com.daniel.application.usecaseimpl;

import br.com.daniel.application.gateway.UpdateGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.usecase.PartialUpdateVehicleUseCase;

public class PartialUpdateVehicleUseCaseImpl implements PartialUpdateVehicleUseCase{
    final private UpdateGateway updateGateway;

    public PartialUpdateVehicleUseCaseImpl(UpdateGateway updateGateway) {
        this.updateGateway = updateGateway;
    }

    @Override
    public Vehicle update(Vehicle vehicle, Vehicle vehicleSaved) throws InternalServerErrorException {

        if(vehicle.getVehicleName() != null) vehicleSaved.setVehicleName(vehicle.getVehicleName());
        if(vehicle.getUrlImg() != null) vehicleSaved.setUrlImg(vehicle.getUrlImg());
        if(vehicle.getBrand() != null) vehicleSaved.setBrand(vehicle.getBrand());
        if(vehicle.getYear() != null) vehicleSaved.setYear(vehicle.getYear());
        if(vehicle.getDescription() != null) vehicleSaved.setDescription(vehicle.getDescription());
        if(vehicle.getSold() != null) vehicleSaved.setSold(vehicle.getSold());

        return updateGateway.update(vehicleSaved);
    }
}
