package com.winneryum.powermock.easymock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.winneryum.powermockito.staticclass.IdGenerator;
import com.winneryum.powermockito.staticclass.ServiceRegistartor;

/**
 * An example on how to mock the call to a static method.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class ServiceRegistratorTest {

    @Test
    public void registersServiceToRepository() throws Exception {
        long expectedId = 42;

        // We create a new instance of the class under test as usually.
        ServiceRegistartor tested = new ServiceRegistartor();

        // This is the way to tell PowerMock to mock all static methods of a given class
        mockStatic(IdGenerator.class);

        /*
         * The static method call to IdGenerator.generateNewId() expectation.
         * This is why we need PowerMock.
         */
        when(IdGenerator.generateNewId()).thenReturn(expectedId);

        long actualId = tested.registerService(new Object());


        verify(IdGenerator.class);


        assertThat(actualId, is(expectedId));
        assertEquals(1.0D,1.0D,0.01D);
    }
}
