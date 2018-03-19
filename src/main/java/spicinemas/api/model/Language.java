package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.db.gen.tables.records.LanguageRecord;

import java.io.Serializable;

@EqualsAndHashCode(exclude = {"id"})
public class Language implements Serializable{
    private Long id;
    private String name;
    private String description;

    public Language(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Language(LanguageRecord languageRecord) {
        this.id = Long.valueOf(languageRecord.getId());
        this.name = languageRecord.getName();
        this.description = languageRecord.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {return description; }

}