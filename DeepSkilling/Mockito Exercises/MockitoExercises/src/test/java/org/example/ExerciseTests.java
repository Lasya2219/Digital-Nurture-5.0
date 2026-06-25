package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ExerciseTests {
    ExternalApi mockApi;
    MyService service;

    @BeforeEach
    public void testExternalApi() {
        mockApi = mock(ExternalApi.class);
        service= new MyService(mockApi);
    }

    // Exercise 3
    @Test
    public void testStrData() {
        service.processData("Hello World");
        verify(mockApi).sendData(anyString());
    }

    @Test
    public void testIntData() {
        service.processIntData(5);
        verify(mockApi).sendIntData(anyInt());
    }

    // Exercise 4
    @Test
    public void testVoidMethod() {
        doNothing().when(mockApi).clearCache();
        service.resetData();
        verify(mockApi).clearCache();
    }

    // Exercise 5
    @Test
    public void testMultipleReturns() {
        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call")
                .thenReturn("Third Call");

        assertEquals("First Call", mockApi.getData());
        assertEquals("Second Call", mockApi.getData());
        assertEquals("Third Call", mockApi.getData());
    }

    // Exercise 6
    @Test
    public void testOrder() {
        service.fetchInfo();

        InOrder inorder = inOrder(mockApi);

        inorder.verify(mockApi).connect();
        inorder.verify(mockApi).getInfo();
        inorder.verify(mockApi).disconnect();
    }

    // Exercise 7
    @Test
    public void testError() {
        doThrow(new RuntimeException("Runtime Error"))
                .when(mockApi)
                .clearCache();

        assertThrows(RuntimeException.class, () -> {
            service.resetData();
        });

        verify(mockApi).clearCache();
    }

}
