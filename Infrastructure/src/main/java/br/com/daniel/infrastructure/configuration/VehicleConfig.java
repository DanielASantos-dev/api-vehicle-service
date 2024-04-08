package br.com.daniel.infrastructure.configuration;

import br.com.daniel.application.gateway.*;
import br.com.daniel.application.usecaseimpl.*;
import br.com.daniel.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfig {

    @Bean
    public RegisterVehicleUseCase registerVehicleUseCase(RegisterGateway registerGateway){
        return new RegisterVehicleUseCaseImpl(registerGateway);
    }
    @Bean
    public FindVehicleByIdUseCase findVehicleByIdUseCase(FindVehicleByIdGateway findVehicleByIdGateway){
        return new FindVehicleByIdUseCaseImpl(findVehicleByIdGateway);
    }
    @Bean
    public UpdateVehicleUseCase updateVehicleUseCase(UpdateGateway updateGateway){
        return new UpdateVehicleUseCaseImpl(updateGateway);
    }

    @Bean
    public DeleteVehicleUseCase deleteVehicleUseCase(DeleteVehicleGateway deleteVehicleGateway){
        return new DeleteVehicleUseCaseImpl(deleteVehicleGateway);
    }

    @Bean
    public FindAllVehiclesOrParamsUseCase findVehiclesByParamsUseCase(FindVehiclesByParamsGateway findVehiclesByParamsGateway){
        return new FindAllVehiclesOrParamsUseCaseImpl(findVehiclesByParamsGateway);
    }

    @Bean
    public PartialUpdateVehicleUseCase partialUpdateVehicleUseCase(UpdateGateway updateGateway){
        return new PartialUpdateVehicleUseCaseImpl(updateGateway);
    }
}
