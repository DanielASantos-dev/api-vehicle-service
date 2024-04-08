package br.com.daniel.application;

import br.com.daniel.application.gateway.UpdateGateway;
import br.com.daniel.application.usecaseimpl.PartialUpdateVehicleUseCaseImpl;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.enums.BrandEnum;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.usecase.PartialUpdateVehicleUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PartialUpdateVehicleUseCaseImplTest {
    PartialUpdateVehicleUseCase partialUpdateVehicleUseCase;
    UpdateGateway updateGateway;

    @BeforeEach
    void setup() {
        updateGateway = mock(UpdateGateway.class);
        partialUpdateVehicleUseCase = new PartialUpdateVehicleUseCaseImpl(updateGateway);
    }

    @Test
    void update_Success() throws InternalServerErrorException {
        Vehicle vehicleToUpdate = new Vehicle("Test Vehicle","www.image.com", BrandEnum.FORD,2020, "Test Description", false);
        Vehicle vehicleSaved = new Vehicle("Test Vehicle","www.image.com", BrandEnum.FORD, 2021, "Test Description", false);
        vehicleSaved.setId(1L);

        Vehicle expectedUpdatedVehicle = new Vehicle("Test Vehicle","www.image.com", BrandEnum.FORD, 2021, "Test Description", false);
        expectedUpdatedVehicle.setId(1L);
        expectedUpdatedVehicle.setUpdatedAt(LocalDateTime.now());

        when(updateGateway.update(any(Vehicle.class))).thenReturn(expectedUpdatedVehicle);

        Vehicle result = partialUpdateVehicleUseCase.update(vehicleToUpdate, vehicleSaved);

        assertEquals(expectedUpdatedVehicle.getYear(), result.getYear());
        assertNotNull(result.getUpdatedAt());

        verify(updateGateway, times(1)).update(vehicleSaved);
    }
}

