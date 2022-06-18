package uz.gita.myquizappp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.example.quiz.R;
import uz.gita.myquizappp.madel.QuizMadel;
import uz.gita.myquizappp.madel.tests.GetListOfQuestion;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestActivity extends AppCompatActivity {

    private static List<QuizMadel> quizMadelsuiz;
    private int count;
    private int correctCount;
    private int wrongCount;
    TextView time;

    public static void setQuiz(List<QuizMadel> quiz) {
        quizMadelsuiz = quiz;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView themeText = findViewById(R.id.theme_text);
        if (quizMadelsuiz == GetListOfQuestion.listJava(getResources()))
        themeText.setText("Java");
        if (quizMadelsuiz == GetListOfQuestion.listKotlin(getResources()))
        themeText.setText("Kotlin");
        if (quizMadelsuiz == GetListOfQuestion.listC(getResources()))
        themeText.setText("C++");
        if (quizMadelsuiz == GetListOfQuestion.listPython(getResources()))
        themeText.setText("Python");
         time  = findViewById(R.id.time);
        time.setText("05:00");
         long duration = TimeUnit.MINUTES.toMillis(5);
         new CountDownTimer(duration, 1000) {
             @Override
             public void onTick(long l) {
                 String sDuration = String.format(Locale.ENGLISH,"%02d : %02d"
                 ,TimeUnit.MILLISECONDS.toMinutes(l)
                 ,TimeUnit.MILLISECONDS.toSeconds(l) -
                         TimeUnit.MINUTES
                                 .toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                 time.setText(sDuration);
             }

             @Override
             public void onFinish() {
                 time.setVisibility(View.GONE);
                 Intent intent = new Intent(TestActivity.this, Result_Activity.class);
                 intent.putExtra("Correct",correctCount);
                 intent.putExtra("Wrong",wrongCount);
                 startActivity(intent);
                 finish();
             }
         }.start();





        TextView variantA = findViewById(R.id.variant_a);
        TextView variantB = findViewById(R.id.variant_b);
        TextView variantC = findViewById(R.id.variant_c);
        TextView variantD = findViewById(R.id.variant_d);
        LinearLayoutCompat variant_a = findViewById(R.id.a);
        LinearLayoutCompat variant_b = findViewById(R.id.b);
        LinearLayoutCompat variant_c = findViewById(R.id.c);
        LinearLayoutCompat variant_d = findViewById(R.id.d);

        loadData();
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> {
            startActivity(new Intent(this,FistActivity.class));
            finish();
        });
        TextView nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(view -> {
            if (count < 10) {
                variant_a.setBackgroundResource(R.drawable.variant_style);
                variant_b.setBackgroundResource(R.drawable.variant_style);
                variant_c.setBackgroundResource(R.drawable.variant_style);
                variant_d.setBackgroundResource(R.drawable.variant_style);
                variant_a.setClickable(true);
                variant_b.setClickable(true);
                variant_c.setClickable(true);
                variant_d.setClickable(true);
                loadData();
            } else {
                Intent intent = new Intent(this, Result_Activity.class);
                intent.putExtra("Correct",correctCount);
                intent.putExtra("Wrong",wrongCount + (10 - count + 1));
                startActivity(intent);
                finish();
            }
                nextButton.setEnabled(false);
        });


        variant_a.setOnClickListener(view -> {
            if (quizMadelsuiz.get(count - 1).getAnswer().contentEquals(variantA.getText())) {
                variant_a.setBackgroundResource(R.drawable.variant_correct);
                correctCount++;
            } else {
                variant_a.setBackgroundResource(R.drawable.variant_wrong_);
                checkCorrect(variantA,variantB,variantC,variantD,variant_a,variant_b,variant_c,variant_d);
                wrongCount++;
            }
            nextButton.setEnabled(true);
            clickble(variant_a,variant_b,variant_c,variant_d);
        });
        variant_b.setOnClickListener(view -> {
            if (quizMadelsuiz.get(count - 1).getAnswer().contentEquals(variantB.getText())) {
                variant_b.setBackgroundResource(R.drawable.variant_correct);
                correctCount++;
            } else {
                wrongCount++;
                variant_b.setBackgroundResource(R.drawable.variant_wrong_);
                checkCorrect(variantA,variantB,variantC,variantD,variant_a,variant_b,variant_c,variant_d);
            }
            nextButton.setEnabled(true);
            clickble(variant_a,variant_b,variant_c,variant_d);
        });
        variant_c.setOnClickListener(view -> {

            if (quizMadelsuiz.get(count - 1).getAnswer().contentEquals(variantC.getText())) {
                variant_c.setBackgroundResource(R.drawable.variant_correct);
                correctCount++;
            } else {
                wrongCount++;
                variant_c.setBackgroundResource(R.drawable.variant_wrong_);
                checkCorrect(variantA,variantB,variantC,variantD,variant_a,variant_b,variant_c,variant_d);
            }
            nextButton.setEnabled(true);
            clickble(variant_a,variant_b,variant_c,variant_d);
        });
        variant_d.setOnClickListener(view -> {
            if (quizMadelsuiz.get(count - 1).getAnswer().contentEquals(variantD.getText())) {
                variant_d.setBackgroundResource(R.drawable.variant_correct);
                correctCount++;
            } else {
                wrongCount++;
                variant_d.setBackgroundResource(R.drawable.variant_wrong_);
                checkCorrect(variantA,variantB,variantC,variantD,variant_a,variant_b,variant_c,variant_d);
            }
            nextButton.setEnabled(true);
            clickble(variant_a,variant_b,variant_c,variant_d);
        });
    }

    @SuppressLint("SetTextI18n")
    private void loadData() {
        TextView countQuestion = findViewById(R.id.question_count);
        countQuestion.setText("Quiz " + (count + 1) + "/10");
        TextView textQuestion = findViewById(R.id.question_text);
        TextView variantA = findViewById(R.id.variant_a);
        TextView variantB = findViewById(R.id.variant_b);
        TextView variantC = findViewById(R.id.variant_c);
        TextView variantD = findViewById(R.id.variant_d);
        textQuestion.setText(quizMadelsuiz.get(count).getQuestion());
        variantA.setText(quizMadelsuiz.get(count).getA());
        variantB.setText(quizMadelsuiz.get(count).getB());
        variantC.setText(quizMadelsuiz.get(count).getC());
        variantD.setText(quizMadelsuiz.get(count).getD());
        count++;
    }

    private void checkCorrect(TextView variantA,TextView variantB,TextView variantC,TextView variantD,LinearLayoutCompat variant_a,LinearLayoutCompat variant_b,LinearLayoutCompat variant_c,LinearLayoutCompat variant_d) {
        if (quizMadelsuiz.get(count - 1).getAnswer().contentEquals(variantA.getText())) {
            variant_a.setBackgroundResource(R.drawable.variant_correct);
        }
        if (quizMadelsuiz.get(count - 1).getAnswer().contentEquals(variantB.getText())) {
            variant_b.setBackgroundResource(R.drawable.variant_correct);
        }
        if (quizMadelsuiz.get(count - 1).getAnswer().contentEquals(variantC.getText())) {
            variant_c.setBackgroundResource(R.drawable.variant_correct);
        }
        if (quizMadelsuiz.get(count - 1).getAnswer().contentEquals(variantD.getText())) {
            variant_d.setBackgroundResource(R.drawable.variant_correct);
        }

    }

    private void clickble(LinearLayoutCompat variant_a,LinearLayoutCompat variant_b,LinearLayoutCompat variant_c,LinearLayoutCompat variant_d) {
        variant_a.setClickable(false);
        variant_b.setClickable(false);
        variant_c.setClickable(false);
        variant_d.setClickable(false);
    }
}