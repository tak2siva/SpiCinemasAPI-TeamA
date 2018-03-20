package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.db.LocationRepository;
import spicinemas.api.model.Location;
import java.util.List;

@RestController
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    @RequestMapping(value = "/location",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> getAllLocations(){
        return locationRepository.getAllLocations();
    }
}
