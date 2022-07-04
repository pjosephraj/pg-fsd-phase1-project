package com.phase1;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class project {

    public static File usrFolder = new File("user-folder");

    public static void main(String[] args) {
        System.out.println("Project: PG FSD Implement OOPS using JAVA with Data Structures and Beyond.");
        System.out.println("==========================================================================");
        mainOptions();
    }

    public static void mainOptions() {
        System.out.println("1. Retrieve Files.");
        System.out.println("2. Business Operations.");
        System.out.println("3. Exit the Application.");
        System.out.println("Please choose an Option (1 to 3)");

        Scanner inp = new Scanner(System.in);

        int optionSelected = inp.nextInt();
        char escSwitch = 'Y';

        do {
            switch (optionSelected) {
                case 1:
                    listFiles();
                    escSwitch = 'N';
                    System.exit(0);
                    break;
                case 2:
                    secondaryOptions();
                    escSwitch = 'N';
                    break;
                case 3:
                    escSwitch = 'N';
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Option, Please choose 1 to 3.");
                    optionSelected = inp.nextInt();
            }
        } while (escSwitch == 'Y');
    }

    public static void secondaryOptions() {

        System.out.println("=================================\n");
        System.out.println("1. Add File.");
        System.out.println("2. Delete File");
        System.out.println("3. Search File.");
        System.out.println("4. Back to Main Options");
        System.out.println("5. Close Application");
        System.out.println("Please choose an Option (1 to 5)");

        Scanner inp = new Scanner(System.in);

        int optionSelected = inp.nextInt();
        char escSwitch = 'Y';

        do {
            switch (optionSelected) {
                case 1:
                    addFile();
                    secondaryOptions();
                    break;
                case 2:
                    deleteFile();
                    secondaryOptions();
                    break;
                case 3:
                    searchFile();
                    secondaryOptions();
                    break;
                case 4:
                    System.out.println("=================================\n");
                    escSwitch = 'Y';
                    mainOptions();
                    break;
                case 5:
                    escSwitch = 'N';
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Option, Please choose 1 to 5.");
                    optionSelected = inp.nextInt();
            }
        } while (escSwitch == 'Y');
    }

    public static void listFiles() {
        System.out.println("List of Files: ");
        try {
            String folderPath = usrFolder.getAbsolutePath();
            File filesFolder = new File(folderPath);
            String[] files = filesFolder.list();
            if (files.length > 0) {
                Arrays.sort(files);
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println(" - No Files Found! - ");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void addFile() {
        System.out.println("Please Enter File Name: ");
        Scanner inp = new Scanner(System.in);
        String fileName = inp.next();
        try {
            FileWriter addedFile = new FileWriter(usrFolder.getAbsolutePath() + "\\" + fileName);
            addedFile.write(fileName + ": created by user");
            addedFile.close();
            System.out.println(fileName + " file created");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void deleteFile() {
        System.out.println("Please Enter File Name to Delete: ");
        Scanner inp = new Scanner(System.in);
        String fileName = inp.next();
        try {
            String folderPath = usrFolder.getAbsolutePath();
            File folderToCheck = new File(folderPath);
            File[] fileFound = folderToCheck.listFiles(new CheckFileName(fileName));
            if (fileFound.length == 1) {
                File file = new File(folderPath + "\\" + fileName);
                file.delete();
            } else {
                System.out.println("File Not Found!");
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void searchFile() {
        System.out.println("Please Enter File Name to Search: ");
        Scanner inp = new Scanner(System.in);
        String fileName = inp.next();

        try {
            String folderPath = usrFolder.getAbsolutePath();
            File folderToCheck = new File(folderPath);
            File[] fileFound = folderToCheck.listFiles(new CheckFileName(fileName));
            if (fileFound.length == 1) {
                System.out.println("File is Exist.");
            } else {
                System.out.println("File Not Found!");
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}

class CheckFileName implements FilenameFilter {
    private String fileName;

    public CheckFileName(String name) {
        this.fileName = name.toLowerCase();
    }

    @Override
    public boolean accept(File dir, String name) {
        String nameLowercase = name.toLowerCase();
        return nameLowercase.startsWith(this.fileName) && nameLowercase.endsWith(this.fileName);
    }
}
