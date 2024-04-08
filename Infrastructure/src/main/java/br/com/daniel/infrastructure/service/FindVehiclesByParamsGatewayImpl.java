package br.com.daniel.infrastructure.service;

import br.com.daniel.application.gateway.FindVehiclesByParamsGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.infrastructure.entity.VehicleEntity;
import br.com.daniel.infrastructure.repository.VehicleRepository;
import br.com.daniel.infrastructure.repository.specification.VehicleSpecifications;
import br.com.daniel.usecase.dto.PageDto;
import br.com.daniel.usecase.dto.PageableDto;
import br.com.daniel.usecase.dto.VehicleFindParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FindVehiclesByParamsGatewayImpl implements FindVehiclesByParamsGateway {
    Logger log = LoggerFactory.getLogger(FindVehiclesByParamsGatewayImpl.class);
    final private VehicleRepository vehicleRepository;
    public FindVehiclesByParamsGatewayImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public PageDto<Vehicle> find(VehicleFindParam criteria, PageableDto pageable) {
        log.info("Start::find::FindVehiclesByParamsGatewayImpl");
        var sortDirection = "desc".equalsIgnoreCase(pageable.direction()) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageableSpring = PageRequest.of(pageable.pageNumber(), pageable.pageSize(), Sort.by(sortDirection, "id"));

        Specification<VehicleEntity> spec = Specification.where(VehicleSpecifications.hasVehicleName(criteria.vehicleName()))
                .and(VehicleSpecifications.hasBrand(criteria.brand()))
                .and(VehicleSpecifications.hasYear(criteria.year()))
                .and(VehicleSpecifications.hasIsSolid(criteria.isSold()))
                .and(VehicleSpecifications.hasCreatedAt(criteria.startDate(), criteria.endDate()));

        var vehicleEntityPage = vehicleRepository.findAll(spec, pageableSpring).map(VehicleEntity::toVehicle);
        log.info("Search performed successfully::find::FindVehiclesByParamsGatewayImpl");
        var pageableResult = new PageableDto(
                vehicleEntityPage.getPageable().getPageNumber(),
                vehicleEntityPage.getPageable().getPageSize(),
                vehicleEntityPage.getPageable().getSort().toString()
        );
        log.info("End::find::FindVehiclesByParamsGatewayImpl");
        return new PageDto<Vehicle>(
                vehicleEntityPage.getContent(),
                vehicleEntityPage.getTotalElements(),
                vehicleEntityPage.getTotalPages(),
                pageableResult);
    }
}
