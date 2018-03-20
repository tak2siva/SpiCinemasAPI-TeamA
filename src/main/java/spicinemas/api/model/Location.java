package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.db.gen.tables.records.LocationRecord;

import java.io.Serializable;


@EqualsAndHashCode(exclude = {"id"})
public class Location implements Serializable{

    private int id;
    private String code;
    private String name;

    public Location(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Location(LocationRecord locationRecord) {
        this.id = locationRecord.getId();
        this.code = locationRecord.getCode();
        this.name = locationRecord.getName();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
