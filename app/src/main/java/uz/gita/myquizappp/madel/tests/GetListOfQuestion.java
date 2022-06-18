package uz.gita.myquizappp.madel.tests;

import android.content.res.Resources;

import com.example.quiz.R;
import uz.gita.myquizappp.madel.QuizMadel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetListOfQuestion {
    public static List<QuizMadel> listJava(Resources resources){
        List<QuizMadel> result = new ArrayList<>();
        String[] questions = resources.getStringArray(R.array.questions_java);
        String[] answers = resources.getStringArray(R.array.questions_java_answers);
        String[] variant_a = resources.getStringArray(R.array.question_variant_java_a);
        String[] variant_b = resources.getStringArray(R.array.question_variant_java_b);
        String[] variant_c = resources.getStringArray(R.array.question_variant_java_c);
        String[] variant_d = resources.getStringArray(R.array.question_variant_java_d);
        for (int i = 0; i < questions.length - 1; i++) {
            QuizMadel quizMadel = new QuizMadel((i + 1),questions[i],answers[i],variant_a[i],variant_b[i],variant_c[i],variant_d[i]);
            result.add(quizMadel);
        }
        Collections.shuffle(result);
        return result;
    }
    public static List<QuizMadel> listKotlin(Resources resources){
        List<QuizMadel> result = new ArrayList<>();
        String[] questions = resources.getStringArray(R.array.question_kotlin);
        String[] answers = resources.getStringArray(R.array.questions_kotlin_answers);
        String[] variant_a = resources.getStringArray(R.array.question_variant_kotlin_a);
        String[] variant_b = resources.getStringArray(R.array.question_variant_kotlin_b);
        String[] variant_c = resources.getStringArray(R.array.question_variant_kotlin_c);
        String[] variant_d = resources.getStringArray(R.array.question_variant_kotlin_d);

        for (int i = 0; i < questions.length - 1; i++) {
            QuizMadel quizMadel = new QuizMadel((i + 1),questions[i],answers[i],variant_a[i],variant_b[i],variant_c[i],variant_d[i]);
            result.add(quizMadel);
        }
        Collections.shuffle(result);
        return result;
    }
    public static List<QuizMadel> listC(Resources resources){

        List<QuizMadel> result = new ArrayList<>();
        String[] questions = resources.getStringArray(R.array.question_c);
        String[] answers = resources.getStringArray(R.array.questions_c_answers);
        String[] variant_a = resources.getStringArray(R.array.question_variant_c_a);
        String[] variant_b = resources.getStringArray(R.array.question_variant_c_b);
        String[] variant_c = resources.getStringArray(R.array.question_variant_c_c);
        String[] variant_d = resources.getStringArray(R.array.question_variant_c_d);

        for (int i = 0; i < questions.length - 1; i++) {
            QuizMadel quizMadel = new QuizMadel((i + 1),questions[i],answers[i],variant_a[i],variant_b[i],variant_c[i],variant_d[i]);
            result.add(quizMadel);
        }
        Collections.shuffle(result);
        return result;
    }
    public static List<QuizMadel> listPython(Resources resources){
        List<QuizMadel> result = new ArrayList<>();
        String[] questions = resources.getStringArray(R.array.question_python);
        String[] answers = resources.getStringArray(R.array.questions_python_answers);
        String[] variant_a = resources.getStringArray(R.array.question_variant_python_a);
        String[] variant_b = resources.getStringArray(R.array.question_variant_python_b);
        String[] variant_c = resources.getStringArray(R.array.question_variant_python_c);
        String[] variant_d = resources.getStringArray(R.array.question_variant_python_d);

        for (int i = 0; i < questions.length - 1; i++) {
            QuizMadel quizMadel = new QuizMadel((i + 1),questions[i],answers[i],variant_a[i],variant_b[i],variant_c[i],variant_d[i]);
            result.add(quizMadel);
        }
        Collections.shuffle(result);
        return result;
    }
}
