package spicinemas.api.db;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spicinemas.api.model.Language;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static spicinemas.db.gen.tables.Language.LANGUAGE;

@Repository
public class LanguageRepository {

    @Autowired
    private DSLContext dsl;

    public List<Language> getAllLanguage() {

        return dsl.selectFrom(LANGUAGE).fetchMap(LANGUAGE.ID)
                .values()
                .stream().map(Language::new).collect(toList());

    }
}
