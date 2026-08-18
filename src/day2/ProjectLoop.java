package day2;

import java.util.Scanner;

public class ProjectLoop {

    // 1) create 2) display 3) raise sal 4) exit
    // Loop continues if user enters 'y' (yes), stops if 'n' (no)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = "";
        int age = 0;
        String designation = "";
        double salary = 0;

        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1) Create");
            System.out.println("2) Display");
            System.out.println("3) Raise Sal");
            System.out.println("4) Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // 1) enter the name (1 word or 2 words with exactly one space)
                    while (true) {
                        System.out.print("Enter name: ");
                        String inputName = sc.nextLine().trim();

                        // Must be either 1 word OR exactly 2 words separated by exactly one space
                        // And words should be alphabetic (you can relax this if needed).
                        if (inputName.matches("[A-Za-z]+") || inputName.matches("[A-Za-z]+ [A-Za-z]+")) {
                            name = inputName;
                            break;
                        } else {
                            System.out.println("Invalid name! Enter 1 word OR 2 words with exactly one space.");
                        }
                    }

                    // 2) enter the age (only 18 to 60)
                    while (true) {
                        System.out.print("Enter age: ");
                        int inputAge = sc.nextInt();
                        sc.nextLine(); // consume newline

                        if (inputAge >= 18 && inputAge <= 60) {
                            age = inputAge;
                            break;
                        } else {
                            System.out.println("Invalid age! Age must be between 18 and 60.");
                        }
                    }

                    // 3) enter the designation (programmer, manager, trainer only)
                    while (true) {
                        System.out.print("Enter designation (programmer/manager/trainer): ");
                        String inputDesignation = sc.nextLine().trim();

                        String lower = inputDesignation.toLowerCase();
                        if (lower.equals("programmer") || lower.equals("manager") || lower.equals("trainer")) {
                            designation = lower; // store normalized value
                            break;
                        } else {
                            System.out.println("Invalid designation! Only programmer, manager, or trainer are allowed.");
                        }
                    }

                    // Optional: initial salary (needed for Raise Sal)
                    System.out.print("Enter current salary: ");
                    salary = sc.nextDouble();
                    sc.nextLine(); // consume newline

                    System.out.println("Employee created successfully!");
                    break;

                case 2:
                    // display
                    if (name.isEmpty()) {
                        System.out.println("No employee created yet. Choose option 1 first.");
                    } else {
                        System.out.println("\n--- Employee Details ---");
                        System.out.println("Name: " + name);
                        System.out.println("Age: " + age);
                        System.out.println("Designation: " + designation);
                        }
                    break;

                case 3:
                    // raise sal
                    if (name.isEmpty()) {
                        System.out.println("No employee created yet. Choose option 1 first.");
                    } else {
                        System.out.print("Enter raise amount (e.g., 5000): ");
                        double raise = sc.nextDouble();
                        sc.nextLine(); // consume newline
                        salary += raise;
                        System.out.println("Salary raised successfully! New salary = " + salary);
                    }
                    break;

                case 4:
                    // exit immediately
                    System.out.println("Exited");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }

            // After enter yes or no (y/n)
            System.out.print("\nContinue? (y/n): ");
            String ans = sc.nextLine().trim().toLowerCase();

            if (ans.equals("n")) {
                System.out.println("Stopped.");
                break;
            } else if (!ans.equals("y")) {
                System.out.println("Invalid input. Stopping.");
                break;
            }
            // if yes, loop repeats to show menu again
        }

        sc.close();
    }
}
