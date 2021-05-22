package com.example.quizapp;

public class Question {
    private final String question;
    private final String[] options;
    private final String[] answers;

    public Question(String question, String[] options, String[] answers) {
        this.question = question;
        this.options = options;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }


    public String[] getOptions() {
        return options;
    }

    public String[] getAnswers() {
        return answers;
    }

}
