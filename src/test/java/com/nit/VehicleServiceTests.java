package com.nit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.nit.controller.VehicleController;
import com.nit.model.Vehicle;
import com.nit.service.VehicleService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(controllers = VehicleController.class)
public class VehicleServiceTests {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleService vehicleService;

    private List<Vehicle> vehicleList;

    @BeforeEach
    void setUp() {
        this.vehicleList = new ArrayList<>();
        this.vehicleList.add(new Vehicle((long) 1, "abc", "abc", 1999, "123"));
        this.vehicleList.add(new Vehicle((long) 2, "def", "def", 2000, "456"));
        this.vehicleList.add(new Vehicle((long) 3, "geh", "ghi", 2001, "789"));
    }

    @Test
    void shouldFetchAllVehicleList() throws Exception {

        given(vehicleService.getVehicles()).willReturn(vehicleList);

        this.mockMvc.perform(get("api/vehicles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(vehicleList.size())));
    }
    
   
}
