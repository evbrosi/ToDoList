import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 * Created by eaglebrosi on 10/11/16.
 */

public class GroceryList {

    String fileName = "groceries.txt";
    String item;
    double itemCost;
    double itemCostPlusTax;
    double kentuckyTax;
    int nowWhat;
    int deleteWhich;
    Scanner whatUpIzaak = new Scanner(System.in);
    ArrayList<String> historyList = new ArrayList<>();

    public void createGroceryList() throws IOException, NumberFormatException, InterruptedException {
        PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
        while (true) {
            System.out.print("\nWelcome to your Grocery Getting!\n \n What are we buying today?\n Please input an item:");
            item = whatUpIzaak.nextLine();
            System.out.print("\nHow much does " + item + " cost?\n Please input the cost: $");
            itemCost = whatUpIzaak.nextDouble();
            System.out.println("\nKentucky's sales tax is 6%.");
            kentuckyTax = (itemCost * 0.06);

            BigDecimal a = new BigDecimal(itemCost+kentuckyTax);
            BigDecimal itemCostPlusTax = a.setScale(2, RoundingMode.DOWN);

            System.out.println("\n Give me a minute");
            System.out.println("\n The " + item + " is going to cost $" + itemCostPlusTax+"\n");
            // some sort of add mechanic
            historyList.add(item +": $" + itemCostPlusTax);
            whatIsNext();
        }
    }

    public void whatIsNext() throws IOException, InterruptedException {
        Menu m1= new Menu();
        PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
        System.out.print("Would you like to do next?\n1: Add another item: \n2: Look at Grocery list: \n3: Delete a Grocery Item.\n4:Just go back to the menu.");
        nowWhat = whatUpIzaak.nextInt();

        switch (nowWhat) {
            case 1:
                createGroceryList();
            case 2:
                System.out.println("");
                for(int i = 0; i < historyList.size(); ++i) {
                    System.out.println(historyList.get(i));
                }
                whatIsNext();
                break;
            case 3:
                System.out.println("Your Grocery List\n");
                for (int i = 0; i < historyList.size(); ++i) {
                    System.out.print(i+1+". ");
                    System.out.println(historyList.get(i));
                }
                System.out.print("\nPlease select the number of which item you want to delete: ");
                deleteWhich = whatUpIzaak.nextInt();
                System.out.print("\nYou are about to delete: ");
                System.out.println(historyList.get(deleteWhich-1));
                historyList.remove(deleteWhich-1);
                whatIsNext();
                break;
            case 4:
                for(int i = 0; i < historyList.size(); ++i) {
                    outFile.println(historyList.get(i));
                }
                m1.main();

                break;
            default:
                System.out.println("I don't understand what you mean.");
                whatIsNext();
        }
    }
}
/*
java.awt.Desktop;
        java.io.File;
Desktop.getDesktop().open(new File(fileName));
*/