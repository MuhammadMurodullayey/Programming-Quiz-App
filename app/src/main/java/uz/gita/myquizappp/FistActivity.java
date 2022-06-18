package uz.gita.myquizappp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.R;
import uz.gita.myquizappp.madel.tests.GetListOfQuestion;

public class FistActivity extends AppCompatActivity {
    ImageView javaView;
    ImageView kotlinView;
    ImageView cView ;
    ImageView pythonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fist);
        javaView = findViewById(R.id.java);
        kotlinView = findViewById(R.id.kotlin);
        cView = findViewById(R.id.c_langulage);
        pythonView = findViewById(R.id.pyton);
        TextView startButton = findViewById(R.id.start);
        eneabledTrue();
        startButton.setEnabled(false);
        ImageView info = findViewById(R.id.info);
        info.setOnClickListener(view -> startActivity(new Intent(this, InfoActivity.class)));
        startButton.setOnClickListener(view -> {
            openInfoActivity();
            finish();
        });

        javaView.setOnClickListener(view -> {
            TestActivity.setQuiz(GetListOfQuestion.listJava(getResources()));
            startButton.setEnabled(true);
            eneabledTrue();
            javaView.setEnabled(false);
        });
        kotlinView.setOnClickListener(view -> {
            TestActivity.setQuiz(GetListOfQuestion.listKotlin(getResources()));
            startButton.setEnabled(true);
            eneabledTrue();
            kotlinView.setEnabled(false);
        });
        cView.setOnClickListener(view -> {
            TestActivity.setQuiz(GetListOfQuestion.listC(getResources()));
            startButton.setEnabled(true);
            eneabledTrue();
            cView.setEnabled(false);
        });
        pythonView.setOnClickListener(view -> {
            TestActivity.setQuiz(GetListOfQuestion.listPython(getResources()));
            startButton.setEnabled(true);
            eneabledTrue();
            pythonView.setEnabled(false);
        });

    }

    private void openInfoActivity() {
        Intent intent = new Intent(FistActivity.this, TestActivity.class);
        startActivity(intent);
    }
    public  void eneabledTrue() {
       javaView.setEnabled(true);
       kotlinView.setEnabled(true);
       cView.setEnabled(true);
       pythonView.setEnabled(true);
    }
}