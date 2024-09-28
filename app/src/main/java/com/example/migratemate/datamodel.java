package com.example.migratemate;

 class DataModel {
    private int image;
    private String date;
    private String description;
    private String url;
    private String additionalInfo; // New field for additional information

    public DataModel(int image, String date, String description, String url, String additionalInfo) {
        this.image = image;
        this.date = date;
        this.description = description;
        this.url = url;
        this.additionalInfo = additionalInfo; // Initialize the new field
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdditionalInfo() {
        return additionalInfo; // Getter for the additional information
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo; // Setter for the additional information
    }
}
