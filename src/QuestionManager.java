import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.IOException;

public class QuestionManager {
//    List<String> quests = new ArrayList<>();
//    List<String> answers = new ArrayList<>();
//    String kindQuest;


    //construct
//    List<String> QuestionManager() {
//        createQuest();
//        System.out.println("yolo:"+readQuestion());
//        return readQuestion();
//    }

//    QuestionManager(String kindQuest,List<String> quests) {
//        this.kindQuest = kindQuest;
//        this.quests = quests;
////        this.answers = answers;
////        createQuest(this.quests);
//
////        createQuest();
//        readQuestion();
//    }

    public List<String> readFileData(String filepath) {
        List<String> tempData = new ArrayList<>();
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                for(String val: myReader.nextLine().toString().replace(" ","").split(",")){
                    tempData.add(val);
                }
            }
            myReader.close();
            return tempData;
        } catch (FileNotFoundException e) {
            System.out.println("Gagal, file tidak ditemukan!");
            e.printStackTrace();
            return tempData;
        }
    }

    public boolean saveFileData(String filepath,List<String> data){
        try {
            FileWriter getFile = new FileWriter(filepath);
            getFile.write(data.toString().replace(" ","").replace("[","").replace("]",""));
            getFile.close();

            return Boolean.TRUE;
//            return "Berhasil, soal telah ditambahkan";

        } catch (IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
//            return "Gagal, file tidak ditemukan!";
        }
    }

    public boolean createQuest(String inputQuest) {
        String filepath = "questsData.txt";
        List<String> getDataQuests = new ArrayList<>();
        try {
            File dataQuests = new File(filepath);
            if (!dataQuests.createNewFile()) {//check is file already exist? if no, so create new file using command : createNewFile)_
                getDataQuests = readFileData(filepath);
            }
            getDataQuests.add(inputQuest);
            saveFileData(filepath,getDataQuests);

            return Boolean.TRUE;
//            return "Berhasil, soal telah ditambahkan!";

        } catch (IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
//            return "Gagal, file tidak ditemukan!";
        }
    }

    public boolean createAnswser(List<String> inputAnswers) {
        String filepath = "answersData.txt";
        List<String> getDataAnswers = new ArrayList<>();
        try {
            File dataAnswers = new File(filepath);
            if (!dataAnswers.createNewFile()) {//check is file already exist? if no, so create new file using command : createNewFile)_
                getDataAnswers = readFileData(filepath);
            }

            getDataAnswers.add(inputAnswers.toString().replaceAll(",","###"));
            saveFileData(filepath,getDataAnswers);

            return Boolean.TRUE;

        } catch (IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public Boolean createAnswerKey(String inputKey) {
        String filepath = "answerKeysData.txt";
        int key = inputKey == "a" || inputKey == "A" ? 0 : inputKey == "b" || inputKey == "B" ? 1 : inputKey == "c" || inputKey == "C" ? 2 : 3;
        List<String> getDataKey = new ArrayList<>();
        try {
            File dataQuests = new File(filepath);
            if (!dataQuests.createNewFile()) {//check is file already exist? if no, so create new file using command : createNewFile)_
                getDataKey = readFileData(filepath);
            }
            getDataKey.add(inputKey);
            saveFileData(filepath,getDataKey);

            return Boolean.TRUE;

        } catch (IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public String removeQuestion(int idx) {
        List<String> tempData = new ArrayList<>();
        try {
            File myObj = new File("questsData.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                for (String val : myReader.nextLine().toString().replace(" ", "").split(",")) {
                    tempData.add(val);
                }
            }
            myReader.close();

            try {
                final String removedVal = tempData.get(2);
                tempData.remove(idx);
                FileWriter getFile = new FileWriter("questsData.txt");
                getFile.write(tempData.toString().replace(" ","").replace("[","").replace("]",""));
                getFile.close();
                return "sukses, data " +removedVal+" terhapus!";
            } catch (IOException e) {
                throw new RuntimeException(e);
                }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "gagal";
        }
    }
}
