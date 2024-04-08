package br.com.daniel.infrastructure.service;

import br.com.daniel.application.gateway.RegisterGateway;
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
public class RegisterGatewayImpl implements RegisterGateway {
    Logger log = LoggerFactory.getLogger(RegisterGatewayImpl.class);
    private final VehicleRepository vehicleRepository;
    public RegisterGatewayImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    @Override
    public Vehicle register(Vehicle vehicle) throws InternalServerErrorException {
        log.info("End::register::RegisterGatewayImpl");
        try {
            return vehicleRepository.save(VehicleEntity.from(vehicle)).toVehicle();
        }catch (Exception e){
            log.error("ERROR::register::RegisterGatewayImpl::Reason -> " + e.getMessage());
            throw  new InternalServerErrorException(ErrorCodeEnum.TT0001.getMessage(), ErrorCodeEnum.TT0001.getCode());
        }
    }
}
