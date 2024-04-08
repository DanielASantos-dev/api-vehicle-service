package br.com.daniel;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.infrastructure.entity.VehicleEntity;
import br.com.daniel.infrastructure.repository.VehicleRepository;
import br.com.daniel.infrastructure.service.DeleteVehicleGatewayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DeleteVehicleGatewayImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    private DeleteVehicleGatewayImpl deleteVehicleGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteVehicleGateway = new DeleteVehicleGatewayImpl(vehicleRepository);
    }

    @Test
    void shouldSuccessfullyDeleteVehicle() throws InternalServerErrorException {
        Vehicle vehicle = mock(Vehicle.class); // Or construct a new Vehicle with specific properties if necessary
        VehicleEntity vehicleEntity = VehicleEntity.from(vehicle);

        doNothing().when(vehicleRepository).delete(any(VehicleEntity.class));

        deleteVehicleGateway.delete(vehicle);

        verify(vehicleRepository, times(1)).delete(vehicleEntity);
    }

    @Test
    void shouldThrowInternalServerErrorExceptionWhenDeletionFails() {
        Vehicle vehicle = mock(Vehicle.class);
        VehicleEntity vehicleEntity = VehicleEntity.from(vehicle);

        doThrow(RuntimeException.class).when(vehicleRepository).delete(vehicleEntity);

        assertThrows(InternalServerErrorException.class, () -> {
            deleteVehicleGateway.delete(vehicle);
        });

        verify(vehicleRepository, times(1)).delete(vehicleEntity);
    }

}
