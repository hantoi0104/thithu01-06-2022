package Controllers;

import IO.ReadWrite;
import Model.Student;
import Sort.SortByDownScore;
import Sort.SortByUpScore;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStudent {
    ArrayList<Student> list_Student = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    ReadWrite readWrite = new ReadWrite();

//    public ManagerStudent() {
//        list_Student = readWrite.read();
//    }

    public void menu() {
        showMenu();
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                showStudentlist();
                break;
            case 2:
                addStudent();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            case 5:
                sort();
                break;
            case 6:
                readFromFile();
                break;
            case 7:
               writeToFile();
                break;
            case 8:
                System.exit(0);
                break;
        }
    }

    public void showMenu() {
        System.out.println("---STUDENT MANAGEMENT PROGRAM---");
        System.out.println("Select function by number (to continue)");
        System.out.println("1. Display student list ");
        System.out.println("2. Add");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Sort");
        System.out.println("6. Read from file");
        System.out.println("7. Write to file");
        System.out.println("8. Exit");
        System.out.println(" Select function");
    }

    public Student createStudent() {
        int id;
        while (true) {
            try {
                System.out.println("Enter ID: ");
                id = Integer.parseInt(sc.nextLine());
                for (Student x : list_Student) {
                    if (x.getId() == id)
                        throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println("nhập sai vui lòng nhập lại");
            }
        }

        String fullName = null;
        while (true) {
            try {
                System.out.println("Enter fullName:");
                fullName = sc.nextLine();
                if (fullName.isEmpty())
                    throw new Exception();
                break;
            } catch (Exception e) {
                System.err.println("Compulsory, please enter");
            }
        }

        int age;
        while (true) {
            try {
                System.out.println("Enter age: ");
                age = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Enter fail, please re-enter");
            }
        }
        System.out.println("Enter gender: ");
        String gender = sc.nextLine();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        float score;
        while (true) {
            try {
                System.out.println("Enter score");
                score = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("please re-enter");
            }
        }

        return new Student(id, fullName, age, gender, address, score);
    }

    public void addStudent() {
        list_Student.add(createStudent());

    }

    public void showStudentlist() {
        for (Student x : list_Student) {
            System.out.println(x);
        }
    }

    public void update() {

        int id;
        boolean isCheck = true;
        while (isCheck) {
            try {
                System.out.println("Enter ID to update: ");
                id = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < list_Student.size(); i++) {
                    if (list_Student.get(i).getId() == id) {
                        System.out.println("ok2");
                        list_Student.set(i, createStudent());
                        readWrite.write(list_Student);
                        isCheck = false;
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println("please re_enter");
            }
        }
    }

    public void delete() {
        int id;
        boolean isCheck = true;
        while (isCheck) {
            try {
                System.out.println("Enter ID to delete: ");
                id = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < list_Student.size(); i++) {
                    if (list_Student.get(i).getId() == id) {
                        list_Student.remove(i);
                        isCheck = false;
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println("please re_enter");
            }
        }
    }

    public void sort() {
        System.out.println("---Sort by score---");
        System.out.println("1. Sort by up score: ");
        System.out.println("2. Sort by down score: ");
        System.out.println("3. Exit: ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                list_Student.sort(new SortByUpScore());
                break;
            case 2:
                list_Student.sort(new SortByDownScore());
                break;
            case 3:
                menu();
                break;
        }

    }

    public void writeToFile() {
        System.out.println("Do you want write to file");
        System.out.println("1.Yes");
        System.out.println("2. No");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                readWrite.write(list_Student);
                break;
            case 2:
                break;
        }
    }

    public void readFromFile() {
        System.out.println("Do you want read from file");
        System.out.println("1.Yes:");
        System.out.println("2. No:");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                list_Student = readWrite.read();
                break;
            case 2:
                break;
        }
    }
}
