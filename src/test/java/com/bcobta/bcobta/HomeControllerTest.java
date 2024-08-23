package com.bcobta.bcobta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bcobta.bcobta.controllers.HomeController;

@SpringBootTest
public class HomeControllerTest {

    @Autowired
    HomeController homeController;

    @Test
    public void homeController_healthCheck_returnsOk() {
        assertEquals(homeController.healthCheck(), "Hola Mundo");
    }
    
    @Test
    public void homeController_getPeople_returnsListOf20People() {
        assertEquals(homeController.getPeople().size(), 20);
    }
}
