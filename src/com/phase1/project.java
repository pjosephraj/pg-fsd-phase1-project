package com.phase1;

import java.util.Scanner;

// Name of Projects
// Number of Sprints 2
// Number of User Stories 3
// Number of tasks: 6
//Virendra Sharma (tedx speaker-black coat)

public class project {
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
            switch(optionSelected) {
                case 1:
                    System.out.println("1 is Selected");
                    escSwitch = 'N';
                    break;
                case 2:
                    System.out.println("2 is Selected");
                    escSwitch = 'N';
                    secondaryOptions();
                    break;
                case 3:
                    System.out.println("3 is Selected");
                    escSwitch = 'N';
                    break;
                default:
                    System.out.println("Wrong Option, Please choose 1 to 3.");
                    optionSelected = inp.nextInt();
            }
        } while (escSwitch == 'Y');
    }

    public static boolean isToContinue() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Do you want to Continue?");
        char option = inp.next().charAt(0);
        return (option == 'Y' || option == 'y');
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
            switch(optionSelected) {
                case 1:
                    System.out.println("1 is Selected Option");
                    escSwitch = 'N';
                    break;
                case 2:
                    System.out.println("2 is Selected Option");
                    escSwitch = 'N';
                    break;
                case 3:
                    System.out.println("3 is Selected Option");
                    escSwitch = 'N';
                    break;
                case 4:
                    System.out.println("4 is Selected Option");
                    escSwitch = 'N';
                    System.out.println("=================================\n");
                    mainOptions();
                    break;
                case 5:
                    System.out.println("5 is Selected Option");
                    escSwitch = 'N';
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Option, Please choose 1 to 5.");
                    optionSelected = inp.nextInt();
            }

            boolean toContinue = isToContinue();
            if(toContinue) {
                System.out.println("=================================\n");
                mainOptions();
            }
        } while (escSwitch == 'Y');
    }
}
