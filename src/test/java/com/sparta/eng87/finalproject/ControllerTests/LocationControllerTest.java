package com.sparta.eng87.finalproject.ControllerTests;

import com.sparta.eng87.finalproject.controllers.LocationController;
import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.services.LocationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.*;

public class LocationControllerTest {
    private LocationController locationController;
    private Model model;
    @BeforeEach
    void setUp(){
        LocationService locationService = Mockito.mock(LocationService.class);
        model = Mockito.mock(Model.class);
        Mockito.when(model.addAttribute(anyString(),any())).thenReturn(new ExtendedModelMap());
        locationController= new LocationController(locationService);
    }

    @Test
    void shouldDirectToAddLocationPage(){
        Assertions.assertEquals(locationController.getAddLocationPage(),"addLocation");
    }

    @Test
    void shouldRedirectToCentresFromEditPage(){
        Assertions.assertEquals(locationController.addLocation("london",2),"redirect:/centres");
    }

    @Test
    void shouldRedirectToEditPage(){
        Assertions.assertEquals(locationController.editLocation(1,model),"editLocation");
    }

    @Test
    void shouldRedirectToCentresFromUpdate(){
        Assertions.assertEquals(locationController.updateLocation(new LocationEntity("London",5),4),
        "redirect:/centres");
    }

    @Test
    void shouldReturnToCentresAfterDeletion(){
        Assertions.assertEquals(locationController.deleteLocation(5,model),
                "redirect:/centres"  );
    }
}
