package uz.gita.myquizappp.madel;

public class QuizMadel {
    private int id;
    private String question;
    private String answer;
    private String a;
    private String b;
    private String c;
    private String d;

    public QuizMadel(int id, String question, String answer, String a, String b, String c, String d) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }
}
