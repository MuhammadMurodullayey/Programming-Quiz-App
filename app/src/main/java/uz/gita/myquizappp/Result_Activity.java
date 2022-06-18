package uz.gita.myquizappp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quiz.R;

public class Result_Activity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = getIntent().getExtras();
        TextView scoreText = findViewById(R.id.score);
        if(bundle != null){
            int correctCount = bundle.getInt("Correct");
            int wrongCount = bundle.getInt("Wrong");
            scoreText.setText("CorrectAnswer: " + correctCount + "\nWrongCount: " + wrongCount);
        }
        findViewById(R.id.menu).setOnClickListener(view -> {
            startActivity(new Intent(this,FistActivity.class));
            finish();
        });
        findViewById(R.id.restart_button).setOnClickListener(view -> {
            startActivity(new Intent(this,TestActivity.class));
            finish();
        });
    }
}