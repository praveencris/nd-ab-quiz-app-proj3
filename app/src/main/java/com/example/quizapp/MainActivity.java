package com.example.quizapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private View question1, question2, question3, question4, question5;
    private int correctAns;
    List<Question> questionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question1 = findViewById(R.id.question_1);
        question2 = findViewById(R.id.question_2);
        question3 = findViewById(R.id.question_3);
        question4 = findViewById(R.id.question_4);
        question5 = findViewById(R.id.question_5);

        questionList = new ArrayList<>();
        questionList.add(new Question(
                "In India, when did the second phase of COVID-19 vaccination start?"
                , new String[]{"December 2020", "January 2021", "February 2021", "March 2021"}
                , new String[]{"March 2021"}
        ));
        questionList.add(new Question(
                "Mild Symptoms of Novel coronavirus are:"
                , new String[]{"Fever", "Cough", "Shortness of breath", "None of above"}
                , new String[]{"Fever", "Cough", "Shortness of breath"}
        ));
        questionList.add(new Question(
                "World Health Organisation on 11 February, 2020 announced an official name for the disease that is causing the 2019 novel coronavirus outbreak? What is the new name of the disease?"
                , new String[]{}
                , new String[]{"COVID-19"}
        ));
        questionList.add(new Question(
                "In a study, which cells are found in COVID-19 patients 'bode well' for long-term immunity?"
                , new String[]{"P-cell", "D-Cell", "T-Cell", "Endothelial Cells"}
                , new String[]{"T-Cell"}
        ));
        questionList.add(new Question(
                "What are the precautions that need to be taken to protect from the coronavirus?"
                , new String[]{"Cover your nose and mouth when sneezing.",
                "Add more garlic into your diet.",
                "Visit your doctor for antibiotics treatment",
                "Wash your hands after every hour."}
                , new String[]{"Cover your nose and mouth when sneezing."}
        ));

        populateQuestions(questionList);

        findViewById(R.id.submitBtn).setOnClickListener(v -> {
            correctAns = 0;
            checkIfCorrect(question1, 1);
            checkIfCorrect(question1, 2);
            checkIfCorrect(question1, 3);
            checkIfCorrect(question1, 4);
            checkIfCorrect(question1, 5);

            Toast.makeText(MainActivity.this, "No. of correct " + correctAns + " out of " + 5, Toast.LENGTH_SHORT).show();
        });

    }

    private void checkIfCorrect(View question1, int questionNumber) {
        switch (questionNumber) {
            case 1:
                int checkedId = ((RadioGroup) question1.findViewById(R.id.rgOptions)).getCheckedRadioButtonId();
                if (checkedId != -1) {
                    String checkedAns = ((RadioButton) question1.findViewById(checkedId)).getText().toString();
                    if (Arrays.asList(questionList.get(0).getAnswers()).contains(checkedAns)) {
                        correctAns = correctAns + 1;
                    }
                }
                break;
            case 2:
                CheckBox checkBoxA = ((CheckBox) question2.findViewById(R.id.optionACheck));
                CheckBox checkBoxB = ((CheckBox) question2.findViewById(R.id.optionBCheck));
                CheckBox checkBoxC = ((CheckBox) question2.findViewById(R.id.optionCCheck));
                CheckBox checkBoxD = ((CheckBox) question2.findViewById(R.id.optionDCheck));

                ArrayList<String> answers = new ArrayList<>(Arrays.asList(questionList.get(1).getAnswers()));
                    if (checkBoxA.isChecked())
                        answers.remove(checkBoxA.getText().toString());

                    if (checkBoxB.isChecked())
                        answers.remove(checkBoxB.getText().toString());

                    if (checkBoxC.isChecked())
                        answers.remove(checkBoxC.getText().toString());

                    if (checkBoxD.isChecked())
                        answers.remove(checkBoxD.getText().toString());

                if (answers.isEmpty() && !checkBoxD.isChecked())
                    correctAns = correctAns + 1;

                break;
            case 3:
                String input = ((EditText) question3.findViewById(R.id.answerEdit)).getText().toString();
                if (!TextUtils.isEmpty(input)) {
                    List<String> answers1 = Arrays.asList(questionList.get(2).getAnswers());
                    if (answers1.contains(input.toUpperCase().trim())
                            || answers1.contains(input.toLowerCase().trim())) {
                        correctAns = correctAns + 1;
                    }
                }
                break;
            case 4:
                checkedId = ((RadioGroup) question4.findViewById(R.id.rgOptions)).getCheckedRadioButtonId();
                if (checkedId != -1) {
                    String checkedAns = ((RadioButton) question4.findViewById(checkedId)).getText().toString();
                    if (Arrays.asList(questionList.get(3).getAnswers()).contains(checkedAns)) {
                        correctAns = correctAns + 1;
                    }
                }
                break;
            case 5:
                checkedId = ((RadioGroup) question5.findViewById(R.id.rgOptions)).getCheckedRadioButtonId();
                if (checkedId != -1) {
                    String checkedAns = ((RadioButton) question5.findViewById(checkedId)).getText().toString();
                    if (Arrays.asList(questionList.get(4).getAnswers()).contains(checkedAns)) {
                        correctAns = correctAns + 1;
                    }
                }
                break;
        }

    }

    private void populateQuestions(List<Question> questionList) {
        for (int i = 0; i < questionList.size(); i++) {
            if (i == 0) {//RB
                ((TextView) question1.findViewById(R.id.questionText)).setText(String.format("1. %s", questionList.get(i).getQuestion()));
                ((RadioButton) question1.findViewById(R.id.optionACheck)).setText(questionList.get(i).getOptions()[0]);
                ((RadioButton) question1.findViewById(R.id.optionBCheck)).setText(questionList.get(i).getOptions()[1]);
                ((RadioButton) question1.findViewById(R.id.optionCCheck)).setText(questionList.get(i).getOptions()[2]);
                ((RadioButton) question1.findViewById(R.id.optionDCheck)).setText(questionList.get(i).getOptions()[3]);
            } else if (i == 1) {
                ((TextView) question2.findViewById(R.id.questionText)).setText(String.format("2. %s", questionList.get(i).getQuestion()));
                ((CheckBox) question2.findViewById(R.id.optionACheck)).setText(questionList.get(i).getOptions()[0]);
                ((CheckBox) question2.findViewById(R.id.optionBCheck)).setText(questionList.get(i).getOptions()[1]);
                ((CheckBox) question2.findViewById(R.id.optionCCheck)).setText(questionList.get(i).getOptions()[2]);
                ((CheckBox) question2.findViewById(R.id.optionDCheck)).setText(questionList.get(i).getOptions()[3]);
            } else if (i == 2) {
                ((TextView) question3.findViewById(R.id.questionText)).setText(String.format("3. %s", questionList.get(i).getQuestion()));
            } else if (i == 3) {
                ((TextView) question4.findViewById(R.id.questionText)).setText(String.format("4. %s", questionList.get(i).getQuestion()));
                ((RadioButton) question4.findViewById(R.id.optionACheck)).setText(questionList.get(i).getOptions()[0]);
                ((RadioButton) question4.findViewById(R.id.optionBCheck)).setText(questionList.get(i).getOptions()[1]);
                ((RadioButton) question4.findViewById(R.id.optionCCheck)).setText(questionList.get(i).getOptions()[2]);
                ((RadioButton) question4.findViewById(R.id.optionDCheck)).setText(questionList.get(i).getOptions()[3]);
            } else if (i == 4) {
                ((TextView) question5.findViewById(R.id.questionText)).setText(String.format("5. %s", questionList.get(i).getQuestion()));
                ((RadioButton) question5.findViewById(R.id.optionACheck)).setText(questionList.get(i).getOptions()[0]);
                ((RadioButton) question5.findViewById(R.id.optionBCheck)).setText(questionList.get(i).getOptions()[1]);
                ((RadioButton) question5.findViewById(R.id.optionCCheck)).setText(questionList.get(i).getOptions()[2]);
                ((RadioButton) question5.findViewById(R.id.optionDCheck)).setText(questionList.get(i).getOptions()[3]);
            }
        }
    }
}