package br.com.daniel.infrastructure.service;

import br.com.daniel.application.gateway.FindVehicleByIdGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.NotFoundException;
import br.com.daniel.core.exception.enums.ErrorCodeEnum;
import br.com.daniel.infrastructure.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FindVehicleByIdGatewayImpl implements FindVehicleByIdGateway {
    Logger log = LoggerFactory.getLogger(FindVehicleByIdGatewayImpl.class);
    final private VehicleRepository vehicleRepository;

    public FindVehicleByIdGatewayImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle find(Long id) throws NotFoundException {
        log.info("Start::find::FindVehicleByIdGatewayImpl");
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCodeEnum.TT0002.getMessage(), ErrorCodeEnum.TT0002.getCode())).toVehicle();
    }
}
