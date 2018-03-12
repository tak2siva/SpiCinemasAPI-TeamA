package spicinemas.api.db;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sethur on 1/10/2016.
 */
@Repository
@Transactional
public class UserRepo {

    @Autowired
    private DSLContext dsl;

}
