package br.com.daniel.application.usecaseimpl;

import br.com.daniel.application.gateway.FindVehiclesByParamsGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.usecase.FindAllVehiclesOrParamsUseCase;
import br.com.daniel.usecase.dto.PageDto;
import br.com.daniel.usecase.dto.PageableDto;
import br.com.daniel.usecase.dto.VehicleFindParam;

public class FindAllVehiclesOrParamsUseCaseImpl implements FindAllVehiclesOrParamsUseCase {
    final private FindVehiclesByParamsGateway findVehiclesByParamsGateway;

    public FindAllVehiclesOrParamsUseCaseImpl(FindVehiclesByParamsGateway findVehiclesByParamsGateway) {
        this.findVehiclesByParamsGateway = findVehiclesByParamsGateway;
    }

    @Override
    public PageDto<Vehicle> find(VehicleFindParam criteria, PageableDto pageableDto) {
        return findVehiclesByParamsGateway.find(criteria, pageableDto);
    }
}
