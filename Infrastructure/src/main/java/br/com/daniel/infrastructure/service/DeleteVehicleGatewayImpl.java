package br.com.daniel.infrastructure.service;

import br.com.daniel.application.gateway.DeleteVehicleGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.core.exception.enums.ErrorCodeEnum;
import br.com.daniel.infrastructure.entity.VehicleEntity;
import br.com.daniel.infrastructure.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteVehicleGatewayImpl implements DeleteVehicleGateway {
    Logger log = LoggerFactory.getLogger(DeleteVehicleGatewayImpl.class);
    final private VehicleRepository vehicleRepository;
    public DeleteVehicleGatewayImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    @Override
    public void delete(Vehicle vehicle) throws InternalServerErrorException {
        log.info("Start::delete::DeleteVehicleGatewayImpl");
        try {
            vehicleRepository.delete(VehicleEntity.from(vehicle));
        }catch (Exception e){
            log.error("ERROR::delete::DeleteVehicleGatewayImpl::Reason -> " + e.getMessage());
            throw  new InternalServerErrorException(ErrorCodeEnum.TT0001.getMessage(), ErrorCodeEnum.TT0001.getCode());
        }
    }
}
