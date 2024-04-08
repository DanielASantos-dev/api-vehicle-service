package br.com.daniel;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.infrastructure.entity.VehicleEntity;
import br.com.daniel.infrastructure.repository.VehicleRepository;
import br.com.daniel.infrastructure.service.UpdateGatewayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateGatewayImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    private UpdateGatewayImpl updateGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateGateway = new UpdateGatewayImpl(vehicleRepository);
    }

    @Test
    void shouldSuccessfullyUpdateVehicle() throws InternalServerErrorException {
        Vehicle vehicle = new Vehicle(); // Set up your vehicle object as needed
        VehicleEntity vehicleEntity = VehicleEntity.from(vehicle);

        when(vehicleRepository.save(any(VehicleEntity.class))).thenReturn(vehicleEntity);

        Vehicle updatedVehicle = updateGateway.update(vehicle);

        assertNotNull(updatedVehicle);
        verify(vehicleRepository, times(1)).save(vehicleEntity);
    }
    @Test
    void shouldThrowInternalServerErrorExceptionWhenUpdateFails() {
        Vehicle vehicle = new Vehicle(); // Set up your vehicle object as needed

        doThrow(RuntimeException.class).when(vehicleRepository).save(any(VehicleEntity.class));

        assertThrows(InternalServerErrorException.class, () -> updateGateway.update(vehicle));

        verify(vehicleRepository, times(1)).save(any(VehicleEntity.class));
    }



}
