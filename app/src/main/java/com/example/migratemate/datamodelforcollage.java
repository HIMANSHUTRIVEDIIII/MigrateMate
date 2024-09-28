package com.example.migratemate;
public class datamodelforcollage {
    private int id;
    private String name;
    private String url;
    private String type;

    public datamodelforcollage(int id, String name, String url, String type) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }
}