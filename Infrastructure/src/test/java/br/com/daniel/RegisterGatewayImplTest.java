package br.com.daniel;

import br.com.daniel.application.gateway.RegisterGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.infrastructure.entity.VehicleEntity;
import br.com.daniel.infrastructure.repository.VehicleRepository;
import br.com.daniel.infrastructure.service.RegisterGatewayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterGatewayImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    private RegisterGateway registerGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        registerGateway = new RegisterGatewayImpl(vehicleRepository);
    }

    @Test
    void shouldSuccessfullyRegisterVehicle() throws InternalServerErrorException {
        Vehicle vehicle = new Vehicle(); // Populate this as needed
        VehicleEntity vehicleEntity = VehicleEntity.from(vehicle);

        when(vehicleRepository.save(any(VehicleEntity.class))).thenReturn(vehicleEntity);

        Vehicle registeredVehicle = registerGateway.register(vehicle);

        assertNotNull(registeredVehicle);
        verify(vehicleRepository, times(1)).save(vehicleEntity);
    }

    @Test
    void shouldThrowInternalServerErrorExceptionWhenRegistrationFails() {
        Vehicle vehicle = new Vehicle(); // Populate this as needed

        doThrow(RuntimeException.class).when(vehicleRepository).save(any(VehicleEntity.class));

        assertThrows(InternalServerErrorException.class, () -> {
            registerGateway.register(vehicle);
        });

        verify(vehicleRepository, times(1)).save(any(VehicleEntity.class));
    }


}
