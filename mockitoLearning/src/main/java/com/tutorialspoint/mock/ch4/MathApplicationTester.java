package com.tutorialspoint.mock.ch4;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.timeout;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
  // @InjectMocks annotation is used to create and inject the mock object
  @InjectMocks
  MathApplication mathApplication = new MathApplication();
  // @Mock annotation is used to create the mock object to be injected
  @Mock
  CalculatorService calcService;

  @Test
  public void testAdd() {
    // add the behavior of calc service to add two numbers
    when(calcService.add(10.0, 20.0)).thenReturn(30.00);
    // test the add functionality
    Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
    verify(calcService, times(1)).add(10.0, 20.0);
  }

  @Test(expected = RuntimeException.class)
  public void testAddWithException() {
    doThrow(new RuntimeException("Add Operation not implemented"))
        .when(calcService.add(10.0, 20.0));
    Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
  }

  @Test
  public void testCallInOrder() {
    // add the behavior to add numbers
    when(calcService.add(20.0, 10.0)).thenReturn(30.0);
    // subtract the behavior to subtract numbers
    when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);
    // test the add functionality
    Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
    // test the subtract functionality
    Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);
    // create an inOrder verifier for a single mock
    InOrder inOrder = inOrder(calcService);
    // following will make sure that add is first called then subtract is called.
    inOrder.verify(calcService).add(20.0, 10.0);
    inOrder.verify(calcService).subtract(20.0, 10.0);

  }

  @Test
  public void testCallback() {
    when(calcService.add(20.0, 10.0)).thenAnswer(new Answer() {
      public Double answer(InvocationOnMock invocation) throws Throwable {
        // get the arguments passed to mock
        Object[] args = invocation.getArguments();
        System.out.println(args[0]);
        System.out.println(args[1]);
        // get the mock
        Object mock = invocation.getMock();
        // return the result
        return 30.0;
      }
    });
    // test the add functionality
    Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
  }

  /**
   * Mockito provides an option to create spy on real objects. When a spy is called, then the actual
   * method of the real object is called.
   */
  @Test
  public void testSpy() {
    Calculator calculator = new Calculator();
    CalculatorService calcServiceSpy = spy(calculator);
    mathApplication.setCalculatorService(calcServiceSpy);
    Assert.assertEquals(mathApplication.add(30.0, 10.0), 40.0, 0);
  }

  /**
   * Mockito provides the capability to reset a mock, so that it can be reused later. Take a look at
   * the following code snippet. //reset mock reset(calcService);Here we've reset a mock object.
   * MathApplication makes use of calcService. Once you reset the mock, the mocked method will fail
   * the test.
   */
  @Test
  public void testReset() {
    // add the behavior to add numbers
    when(calcService.add(20.0, 10.0)).thenReturn(30.0);
    // test the add functionality
    Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
    // reset the mock
    reset(calcService);
    // test the add functionality after resetting the mock
    Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
  }
  
  @Test
  public void testTimeout(){
  //add the behavior to add numbers
    when(calcService.add(20.0,10.0)).thenReturn(30.0);
    //subtract the behavior to subtract numbers
    when(calcService.subtract(20.0,10.0)).thenReturn(10.0);
    //test the subtract functionality
    Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);
    //test the add functionality
    Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);
    //verify call to add method to be completed within 100 ms
    verify(calcService, timeout(100)).add(20.0,10.0);
    //invocation count can be added to ensure multiplication invocations
    //can be checked within given timeframe
    verify(calcService, timeout(100).times(1)).subtract(20.0,10.0);
  }
}

