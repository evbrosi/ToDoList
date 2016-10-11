import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by eaglebrosi on 10/11/16.
 */
public class Chore {
    String thingToDo;
    int priority;
    int timeAllocate;
    double kentuckyTax;
    String doneAnything;
    int nowWhat;
    int deleteItem;
    Scanner whatNow = new Scanner(System.in);
    ArrayList<String> choreHistory = new ArrayList<>();

    public void choreChart() throws IOException, NumberFormatException, InterruptedException {

        while (true) {
            System.out.print("Welcome to your Chore Chart!\n \n What do you have to do?\n Please input an chore:");
            thingToDo = whatNow.nextLine();
            System.out.print("\nHow long will it take to " + thingToDo + "?\n Please input the estimated time in minutes: ");
            timeAllocate = whatNow.nextInt();
            System.out.print("\nHow important is it for " + thingToDo + "to get done?\n1: Divorce immenant\n2: Important\n3: Not that necessary\nPlease input the number which best describes " + thingToDo + " importances.");
            priority = whatNow.nextInt();
            System.out.println("\nIt will take you " + timeAllocate + " minutes to " + thingToDo + " and it's a level " + priority + " priority!\n");
            choreHistory.add(priority + " " + thingToDo + " will take " + timeAllocate + " minutes.");
            menu();
        }
    }


    public void menu() throws IOException, InterruptedException {
        Menu m1 = new Menu();
        System.out.print("What would you like to do next?\n1: Add another item: \n2: Look at chore list: \n3: Just go back to the menu.");
        nowWhat = whatNow.nextInt();

        switch (nowWhat) {
            case 1:
                choreChart();
                break;
            case 2:
                printChores();
                break;
            case 3:
                m1.main();
                break;
            default:
                System.out.println("I don't understand what you mean.");
                menu();
                break;
        }
    }

    public void printChores() throws IOException, InterruptedException {
        System.out.println("\n\nYour Chore Chart\n");
        for (int i = 0; i < choreHistory.size(); ++i) {
            System.out.print(i + 1 + ". ");
            System.out.println(choreHistory.get(i));
        }
        System.out.print("\nHave you gotten anything done? Y or N:\n");

        doneAnything = whatNow.nextLine().toUpperCase();
//        doneAnything = doneAnything.toUpperCase();
//toDownCase
        switch (deleteItem) {
            case ('N'):
                menu();
                break;
            case ('Y'):
                deleteThatChore();
                break;
            default:
                System.out.println("I can't understand you!");
                menu();
                break;
        }
    }

    public void deleteThatChore() throws IOException, InterruptedException {
        System.out.println("Your Chore Chart\n");
        for (int i = 0; i < choreHistory.size(); ++i) {
            System.out.print(i + 1 + ". ");
            System.out.println(choreHistory.get(i));
        }
        System.out.print("\nPlease select the number of which item you want to delete: ");
        deleteItem = whatNow.nextInt();
        System.out.print("\nYou are about to delete: ");
        System.out.println(choreHistory.get(deleteItem - 1));
        choreHistory.remove(deleteItem - 1);
        menu();
    }
}
