import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.IOException;
import org.json.JSONArray;
import com.google.gson.Gson;

public class BankQuestion {
    List<String> quests = new ArrayList<>();
    List<String> answers = new ArrayList<>();
    String kindQuest;
//    public static void main(String[] args) {
//        try {
//            File myObj = new File("filename.txt");
//            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }

    BankQuestion(String kindQuest,List<String> quests) {
        this.kindQuest = kindQuest;
        this.quests = quests;
//        this.answers = answers;
        createQuestion(this.quests);
        readQuestion();
    }

//    public static void main(String[] args) {
//createQuestion();
//readQuestion();
//    }


    public void createQuestion(List<String> quests) {
//        String[] quests = {
//                "MCU merupakan singkatan dari?",
//                "Siapa nama actor dari Spider-man versi MCU?",
//                "Apa judul dari film kedua Dr. Strange?",
//        };

        try {
            FileWriter myWriter = new FileWriter("questsData.txt");
//            JSONArray json_array= new JSONArray();
//            for (int i = 0; i < quests.length; i++) {
//                myWriter.write(String.valueOf(quests[i]));
//            }
//            Gson gson = new Gson();
            myWriter.write(String.valueOf(quests));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readQuestion() {
        try {
            File myObj = new File("questsData.txt");
            Scanner myReader = new Scanner(myObj);
            List<String> tempData = new ArrayList<>();
            while (myReader.hasNextLine()) {
                tempData.add(myReader.nextLine());
            }
            myReader.close();
            System.out.println("final: "+tempData);
//            System.out.println("final"+tempData.get(1));
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
