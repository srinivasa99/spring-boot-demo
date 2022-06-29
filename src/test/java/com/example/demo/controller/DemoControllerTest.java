package com.example.demo.controller;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.Assert;

public class DemoControllerTest {

    @Mock
    DemoController demoController;


    @Test
    public void testDisplay(){
        Mockito.when(demoController.displayMessage()).thenReturn("Hello");
        
    }

}
