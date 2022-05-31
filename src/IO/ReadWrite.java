package IO;

import Model.Student;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite {

    public ArrayList<Student> read() {
        File file = new File("file.csv");
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String fullName = arr[1];
                int age = Integer.parseInt(arr[2]);
                String gender = arr[3];
                String address = arr[4];
                float score = Float.parseFloat(arr[5]);
                arrayList.add(new Student(id, fullName, age, gender, address, score));
                str = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    public void write(ArrayList<Student> list) {
        File file = new File("file.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student x : list) {
                bufferedWriter.write(x.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
