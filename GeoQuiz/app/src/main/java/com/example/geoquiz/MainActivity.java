package com.example.geoquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import models.Question;

public class MainActivity extends AppCompatActivity {

    private List<Question> questionList;
    private int curQuestionIdx= 0;
    TextView tvQuestionContent;
    final static String TAG = "GEOQUIZ";
    public final static String CUR_QUESTION_IDX = "CUR_QUESTION_IDX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        generateQuestion();

        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.activity_main, null);

        if(savedInstanceState != null) {
            curQuestionIdx = savedInstanceState.getInt(CUR_QUESTION_IDX,0);
            Log.d(TAG,"onCreate" + curQuestionIdx);
        }

        tvQuestionContent = view.findViewById(R.id.tvQuestionContent);
        showCurQuestion();

        setContentView(view);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"onSaveInstanceState" + curQuestionIdx);
        outState.putInt(CUR_QUESTION_IDX, curQuestionIdx);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    private void showCurQuestion() {
        Question question = questionList.get(curQuestionIdx); // lay cau hoi hien tai
        tvQuestionContent.setText(question.getContent());
    }

    private void generateQuestion() {
        questionList = new ArrayList<>();
        questionList.add(new Question(getString(R.string.questionA), true));
        questionList.add(new Question(getString(R.string.questionB), true));
        questionList.add(new Question(getString(R.string.questionC), true));
        questionList.add(new Question(getString(R.string.questionE), false));
        questionList.add(new Question(getString(R.string.questionD), true));
        questionList.add(new Question(getString(R.string.questionF), true));
        questionList.add(new Question(getString(R.string.questionG), true));
        questionList.add(new Question(getString(R.string.questionH), false));
    }

    public void btTrue_onClick(View view) {
        checkAnswerAndNextQuestion(true);


    }

    private void checkAnswerAndNextQuestion(boolean userAnswer) {
        Question question = questionList.get(curQuestionIdx);
        Boolean answer = question.getAnswer();
        if(answer == userAnswer){
            Toast.makeText(this, "Bạn đã trả lời ĐÚNG", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Bạn đã trả lời SAI", Toast.LENGTH_SHORT).show();
        }
        showNextQuestion();
    }

    private void showNextQuestion() {
        curQuestionIdx++;
        if(curQuestionIdx >= questionList.size()) {
            curQuestionIdx = 0;
        }
        showCurQuestion();
    }

    public void btFalse_onClick(View view) {
        checkAnswerAndNextQuestion(false);
    }
}