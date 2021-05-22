package com.example.quizapp;

import java.util.Arrays;
import java.util.List;

public class Question {
    private String question;
    private String[] options;
    private String[] answers;

    public Question(String question, String[] options, String[] answers) {
        this.question = question;
        this.options = options;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answers=" + Arrays.toString(answers) +
                '}';
    }
}
