package br.com.daniel;


import br.com.daniel.application.gateway.FindVehicleByIdGateway;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.exception.NotFoundException;
import br.com.daniel.infrastructure.entity.VehicleEntity;
import br.com.daniel.infrastructure.repository.VehicleRepository;
import br.com.daniel.infrastructure.service.FindVehicleByIdGatewayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class FindVehicleByIdGatewayImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    private FindVehicleByIdGateway findVehicleByIdGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        findVehicleByIdGateway = new FindVehicleByIdGatewayImpl(vehicleRepository);
    }

    @Test
    void shouldReturnVehicleWhenFound() throws NotFoundException {
        VehicleEntity mockVehicleEntity = mock(VehicleEntity.class);
        when(vehicleRepository.findById(anyLong())).thenReturn(Optional.of(mockVehicleEntity));
        when(mockVehicleEntity.toVehicle()).thenReturn(new Vehicle()); // Assuming you have a method to convert to the domain model

        Vehicle result = findVehicleByIdGateway.find(1L);

        assertNotNull(result);
        verify(vehicleRepository, times(1)).findById(1L);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenVehicleNotFound() {
        when(vehicleRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> findVehicleByIdGateway.find(1L));

        verify(vehicleRepository, times(1)).findById(1L);
    }


}
