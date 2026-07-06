package org.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ExerciseTest2 {
    @Test
    public void testApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchData();
        verify(mockApi).getData();
        // returns true as getData is called in fetchData
    }
}
