import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file source: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter the file destination: ");
        String desPath = scanner.nextLine();


        Main.copyTextFile(sourcePath,desPath);

    }
    public static void copyTextFile(String pathSource, String pathDes){
        File fileSource = new File(pathSource);
        File fileDes = new File(pathDes);
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        if(!fileSource.exists()){
            System.out.println("File source did not exist");
            return;
        }
        try{
            fileReader = new FileReader(fileSource);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(fileDes);
            String line;
            while ((line = bufferedReader.readLine()) != null){
               fileWriter.write(line+"\n");
            }

            fileReader.close();
            bufferedReader.close();
            fileWriter.flush();
            fileWriter.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
