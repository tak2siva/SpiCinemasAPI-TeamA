package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.db.gen.tables.records.LanguageRecord;

import java.io.Serializable;

@EqualsAndHashCode(exclude = {"id"})
public class Language implements Serializable{
    private Long id;
    private String code;
    private String description;

    public Language(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Language(LanguageRecord languageRecord) {
        this.id = Long.valueOf(languageRecord.getId());
        this.code = languageRecord.getCode();
        this.description = languageRecord.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {return description; }

}