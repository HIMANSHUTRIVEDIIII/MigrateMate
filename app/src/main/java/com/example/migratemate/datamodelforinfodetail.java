package com.example.migratemate;

public class datamodelforinfodetail {
    int image;
    String question;
    String answer;

    public datamodelforinfodetail(int image, String question, String answer) {
        this.image = image;
        this.question = question;
        this.answer = answer;
    }

    public int getImage() {
        return image;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
