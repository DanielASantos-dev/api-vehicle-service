package br.com.daniel.application;

import br.com.daniel.application.gateway.RegisterGateway;
import br.com.daniel.application.usecaseimpl.RegisterVehicleUseCaseImpl;
import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.enums.BrandEnum;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.usecase.RegisterVehicleUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class RegisterVehicleUseCaseImplTest {

    RegisterVehicleUseCase registerVehicleUseCase;
    RegisterGateway registerGateway;

    @BeforeEach
    void setup(){
        registerGateway = mock(RegisterGateway.class);
        registerVehicleUseCase = new RegisterVehicleUseCaseImpl(registerGateway);
    }

    @Test
    void testRegister_InSuccess() throws InternalServerErrorException {
        Vehicle expectedVehicle = new Vehicle("Test Vehicle","www.image.com", BrandEnum.FORD, 2020, "Test Description", false);
        when(registerGateway.register(expectedVehicle))
                .thenReturn(expectedVehicle);

        Vehicle result = registerGateway.register(expectedVehicle);
        assertSame(expectedVehicle, result);

        verify(registerGateway, times(1)).register(expectedVehicle);
    }
}
