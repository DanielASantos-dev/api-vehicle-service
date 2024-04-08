package br.com.daniel.application;

import br.com.daniel.application.gateway.FindVehiclesByParamsGateway;
import br.com.daniel.application.usecaseimpl.FindAllVehiclesOrParamsUseCaseImpl;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.enums.BrandEnum;
import br.com.daniel.usecase.FindAllVehiclesOrParamsUseCase;
import br.com.daniel.usecase.dto.PageDto;
import br.com.daniel.usecase.dto.PageableDto;
import br.com.daniel.usecase.dto.VehicleFindParam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class FindAllVehiclesOrParamsUseCaseImplTest {
    private FindVehiclesByParamsGateway mockGateway;
    private FindAllVehiclesOrParamsUseCase useCase;
    private List<Vehicle> vehicles;

    @BeforeEach
    void setUp() {
        mockGateway = Mockito.mock(FindVehiclesByParamsGateway.class);
        useCase = new FindAllVehiclesOrParamsUseCaseImpl(mockGateway);
        Vehicle testVehicle1 = new Vehicle("Test Vehicle", "www.image.com", BrandEnum.FORD, 2020, "Test Description", false);
        Vehicle testVehicle2 = new Vehicle("Test Vehicle 2", "www.image.com", BrandEnum.CHEVROLET, 2021, "Test Description", false);
        vehicles = Arrays.asList(testVehicle1, testVehicle2);
    }

    @Test
    void find_ReturnsExpectedPage() {
        PageDto<Vehicle> expectedPage = new PageDto<>(vehicles, 0, 10, null);
        VehicleFindParam criteria = new VehicleFindParam(null, null, null, null, null, null);
        PageableDto pageableDto = new PageableDto(0, 10, "ASC");
        when(mockGateway.find(criteria, pageableDto)).thenReturn(expectedPage);
        PageDto<Vehicle> result = useCase.find(criteria, pageableDto);
        assertSame(expectedPage, result);
        assertEquals(2, result.content().size());
        verify(mockGateway, times(1)).find(criteria, pageableDto);
    }
}
