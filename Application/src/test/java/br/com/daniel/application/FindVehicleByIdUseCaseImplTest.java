package br.com.daniel.application;

import br.com.daniel.application.gateway.FindVehicleByIdGateway;
import br.com.daniel.application.usecaseimpl.FindVehicleByIdUseCaseImpl;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.enums.BrandEnum;
import br.com.daniel.core.exception.NotFoundException;
import br.com.daniel.core.exception.enums.ErrorCodeEnum;
import br.com.daniel.usecase.FindVehicleByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class FindVehicleByIdUseCaseImplTest {
    private FindVehicleByIdGateway mockGateway;
    private FindVehicleByIdUseCase findVehicleByIdUseCase;

    @BeforeEach
    void setUp() {
        mockGateway = mock(FindVehicleByIdGateway.class);
        findVehicleByIdUseCase = new FindVehicleByIdUseCaseImpl(mockGateway);
    }

    @Test
    void findById_ReturnsVehicle() throws NotFoundException {
        Long vehicleId = 1L;
        Vehicle expectedVehicle = new Vehicle("Test Vehicle","www.image.com", BrandEnum.FORD, 2020, "Test Description", false);
        when(mockGateway.find(vehicleId)).thenReturn(expectedVehicle);
        Vehicle result = findVehicleByIdUseCase.findById(vehicleId);
        assertEquals(expectedVehicle, result);
        assertEquals(2020, result.getYear());
        verify(mockGateway, times(1)).find(vehicleId);
    }

    @Test
    void findById_Failure() throws NotFoundException {
        doThrow(new NotFoundException(ErrorCodeEnum.TT0002.getMessage(), ErrorCodeEnum.TT0002.getCode()))
                .when(mockGateway).find(1L);

        assertThrows(NotFoundException.class, () -> mockGateway.find(1L));
        verify(mockGateway, times(1)).find(1L);
    }

}
