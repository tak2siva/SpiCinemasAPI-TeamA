package spicinemas.api.db;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spicinemas.api.model.Location;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static spicinemas.db.gen.tables.Location.LOCATION;

@Repository
public class LocationRepository {

    @Autowired
    private DSLContext dsl;

    public List<Location> getAllLocations() {
        return dsl.selectFrom(LOCATION).fetchMap(LOCATION.ID)
                .values()
                .stream().map(Location::new).collect(toList());
    }
}
