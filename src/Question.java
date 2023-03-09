import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Question {
String kindQuest;
String[] quests;
String[][] answers;
String[] answerKeys = {"a","b","c"};

    public Question(String consKindQuest, String[] consQuest, String[][] consAnswers){
        this.kindQuest = consKindQuest;
        this.quests = consQuest;
        this.answers = consAnswers;
        printQuestions(this.quests,this.answers);
    }

    void printQuestions(String[] quests, String[][] answers) {
//        int x = 0;
//        Arrays.stream(quests).forEach(vals -> {
//            System.out.println("Daftar Soal");
//            System.out.println(vals);
//            System.out.println("Jawaban:");
//            System.out.println("\n");
//        x+=1;
//        });


        System.out.println("Daftar Soal");
        int x = 0;
        for (String quest : quests){
            System.out.println(x+1+". "+quest);
            System.out.println("Jawaban:");

            int z = 0;
            for (String answer : answers[x]){
                    System.out.println(this.answerKeys[z]+ ") "+answer);
                z++;
            }
            System.out.println("\n");
            x++;
        }
    }

}
