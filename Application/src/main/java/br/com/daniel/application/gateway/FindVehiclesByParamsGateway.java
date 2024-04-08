package br.com.daniel.application.gateway;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.usecase.dto.PageDto;
import br.com.daniel.usecase.dto.PageableDto;
import br.com.daniel.usecase.dto.VehicleFindParam;

public interface FindVehiclesByParamsGateway {
     PageDto<Vehicle> find(VehicleFindParam criteria, PageableDto pageableDto);
}
