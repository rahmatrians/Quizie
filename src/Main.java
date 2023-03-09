import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        QuestionManager addQuest = new QuestionManager();

        Scanner input = new Scanner(System.in);

//        String removeResp = addQuest.removeQuestion(2);
//        System.out.println(removeResp);

        int qty = 2;
        String[] keys = {"a","b","c"};
        for (int i = 1; i <= qty; i++) {
            System.out.println("Type Quest: ");
            String inputQuest = input.nextLine();
            addQuest.createQuest(inputQuest);

            System.out.println("Type Answers: ");
            List<String> inputAnswer = new ArrayList<>();
            for (int x = 1; x <= 3; x++) {
                System.out.println(keys[x-1]+")");
                inputAnswer.add(input.nextLine());
            }
            addQuest.createAnswser(inputAnswer);

            System.out.println("Type Answer Key: ");
            String inputKey = input.nextLine();
            addQuest.createAnswerKey(inputKey);
        }
//        List<String> test = addQuest.readQuestion();
//        System.out.println("hasil:"+addQuest.readQuestion().get(3));
    }
}