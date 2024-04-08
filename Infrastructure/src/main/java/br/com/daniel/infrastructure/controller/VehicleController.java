package br.com.daniel.infrastructure.controller;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.enums.BrandEnum;
import br.com.daniel.core.exception.BadRequestException;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.core.exception.NotFoundException;
import br.com.daniel.infrastructure.dto.request.RegisterVehicle;
import br.com.daniel.infrastructure.dto.request.UpdateVehicle;
import br.com.daniel.infrastructure.dto.response.BaseResponse;
import br.com.daniel.usecase.*;
import br.com.daniel.usecase.dto.PageDto;
import br.com.daniel.usecase.dto.PageableDto;
import br.com.daniel.usecase.dto.VehicleFindParam;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    Logger log = LoggerFactory.getLogger(VehicleController.class);
    final private RegisterVehicleUseCase registerVehicleUseCase;
    final private UpdateVehicleUseCase updateVehicleUseCase;
    final private FindVehicleByIdUseCase findVehicleByIdUseCase;
    final private DeleteVehicleUseCase deleteVehicleUseCase;
    final private FindAllVehiclesOrParamsUseCase findAllVehiclesOrParamsUseCase;
    final private PartialUpdateVehicleUseCase partialUpdateVehicleUseCase;

    public VehicleController(RegisterVehicleUseCase registerVehicleUseCase, UpdateVehicleUseCase updateVehicleUseCase, FindVehicleByIdUseCase findVehicleByIdUseCase, DeleteVehicleUseCase deleteVehicleUseCase, FindAllVehiclesOrParamsUseCase findAllVehiclesOrParamsUseCase, PartialUpdateVehicleUseCase partialUpdateVehicleUseCase) {
        this.registerVehicleUseCase = registerVehicleUseCase;
        this.updateVehicleUseCase = updateVehicleUseCase;
        this.findVehicleByIdUseCase = findVehicleByIdUseCase;
        this.deleteVehicleUseCase = deleteVehicleUseCase;
        this.findAllVehiclesOrParamsUseCase = findAllVehiclesOrParamsUseCase;
        this.partialUpdateVehicleUseCase = partialUpdateVehicleUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<String> register(@Valid  @RequestBody RegisterVehicle request) throws BadRequestException, InternalServerErrorException {
        log.info("Start::registe::VehicleControllerr");
        registerVehicleUseCase.register(request.toVehicle());
        log.info("End::register::VehicleController");
        return BaseResponse.<String>builder().success(true).message("Vehicle successfully registered").build();
    }

    @PutMapping("/{id}")
    public BaseResponse<String> update(@Valid @PathVariable Long id, @RequestBody UpdateVehicle request) throws InternalServerErrorException, NotFoundException {
        log.info("Start::update::VehicleController");
        var vehicleSaved = findVehicleByIdUseCase.findById(id);
        updateVehicleUseCase.update(request.toVehicle(), vehicleSaved);
        log.info("End::update::VehicleController");
        return BaseResponse.<String>builder().success(true).message("Vehicle successfully updated").build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> delete(@PathVariable Long id) throws InternalServerErrorException, NotFoundException {
        log.info("Start::delete::VehicleController");
        var vehicle = findVehicleByIdUseCase.findById(id);
        deleteVehicleUseCase.delete(vehicle);
        log.info("End::delete::VehicleController");
        return BaseResponse.<String>builder().success(true).message("Vehicle successfully deleted").build();
    }

    @GetMapping("/{id}")
    public BaseResponse<Vehicle> findById(@PathVariable Long id) throws NotFoundException {
        log.info("Start::findById::VehicleController");
        var response = findVehicleByIdUseCase.findById(id);
        log.info("End::findById::VehicleController");
        return BaseResponse.<Vehicle>builder().success(true).result(response).build();
    }

    @GetMapping
    public BaseResponse<PageDto<Vehicle>> findAllOrParams(@RequestParam(required = false) String vehicleName, @RequestParam(required = false) BrandEnum brand, @RequestParam(required = false) Integer year, @RequestParam(required = false) Boolean isSold, @RequestParam(required = false) LocalDate startDate, @RequestParam(required = false) LocalDate endDate, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "500") Integer size, @RequestParam(defaultValue = "ASC") String sort) {
        log.info("Start::findAllOrParams::VehicleController");
        var response = findAllVehiclesOrParamsUseCase.find(VehicleFindParam.vehicleFindParamFactory(vehicleName, brand, year, isSold, startDate != null ? startDate.atStartOfDay() : null, endDate != null ? endDate.atTime(LocalTime.MAX) : null), PageableDto.pageableDtoFactory(page, size, sort));
        log.info("End::findAllOrParams::VehicleController");
        return BaseResponse.<PageDto<Vehicle>>builder().success(true).result(response).build();
    }

    @PatchMapping("/{id}")
    public BaseResponse<String> partialUpdate(@PathVariable Long id, @RequestBody UpdateVehicle request) throws InternalServerErrorException, NotFoundException {
        log.info("Start::register:VehicleControllerVehicleController");
        var vehicleSaved = findVehicleByIdUseCase.findById(id);
        partialUpdateVehicleUseCase.update(request.toVehicle(), vehicleSaved);
        log.info("End::findAllOrParams::VehicleController");
        return BaseResponse.<String>builder().success(true).message("Vehicle successfully updated").build();
    }
}
