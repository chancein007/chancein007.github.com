package com.winneryum.powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
@RunWith(PowerMockRunner.class)
@PrepareForTest( { SingleStaticInstance.class })
public class SingleStaticInstanceTest {
  @Test
  public void testMockSingle(){ 
     PowerMockito.mockStatic(SingleStaticInstance.class);
     PowerMockito.when(SingleStaticInstance.getCache()).thenReturn(mock(SingleStaticInstance.class));
     PowerMockito.when(SingleStaticInstance.getID()).thenReturn(2);
     assertEquals(2,SingleStaticInstance.getID());
  }


}
