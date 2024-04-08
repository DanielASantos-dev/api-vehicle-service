package br.com.daniel.application;

import br.com.daniel.application.gateway.DeleteVehicleGateway;
import br.com.daniel.application.usecaseimpl.DeleteVehicleUseCaseImpl;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.enums.BrandEnum;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.usecase.DeleteVehicleUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


class DeleteVehicleUseCaseImplTest {
    private DeleteVehicleGateway mockGateway;
    private Vehicle testVehicle;
    private DeleteVehicleUseCase deleteVehicleUseCase;

    @BeforeEach
    void setup(){
        mockGateway = Mockito.mock(DeleteVehicleGateway.class);
        testVehicle = new Vehicle("Test Vehicle", "www.image.com", BrandEnum.FORD, 2020, "Test Description", false);
        deleteVehicleUseCase = new DeleteVehicleUseCaseImpl(mockGateway);
    }
    @Test
    void deleteVehicle_Success() throws Exception {
        deleteVehicleUseCase.delete(testVehicle);
        verify(mockGateway, times(1)).delete(testVehicle);
    }

    @Test
    void deleteVehicle_Failure() throws InternalServerErrorException {
        doThrow(new InternalServerErrorException("Internal server error", "0001"))
                .when(mockGateway).delete(testVehicle);
        assertThrows(InternalServerErrorException.class, () -> deleteVehicleUseCase.delete(testVehicle));
        verify(mockGateway, times(1)).delete(testVehicle);
    }




}