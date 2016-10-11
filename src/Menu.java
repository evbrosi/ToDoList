import java.io.IOException;
import java.util.Scanner;

/**
 * Created by eaglebrosi on 10/11/16.
 */
public class Menu {
    Chore c1 =new Chore();
    GroceryList g1 =new GroceryList();
    public void main() throws IOException, InterruptedException {
        int menuChoice;
        String fileName = "help.txt";
        Scanner firstNum = new Scanner(System.in);

        //block out the menu (did it differently here than tip calculator because I figured I might have to add things)//
        System.out.println("\n*****The HoneyDew List*****\n");
        System.out.println("1: Chore\n");
        System.out.println("2: Schedule an Event\n");
        System.out.println("3: Grocery List\n");
        System.out.println("4: Help\n");
        System.out.println("5: Quit\n");
        System.out.print("Please enter the number of how you'd like to proceed:");

        menuChoice = firstNum.nextInt();

        switch (menuChoice) {
            case 1:
                c1.choreChart();
                break;
            case 2:
                //     Schedule.SOMETHING();
                break;
            case 3:
                g1.createGroceryList();
                break;
            case 4:

                break;
            case 5:
                System.out.println("Thank you for using Eagle. This is just like prom.");
                main();
                break;
            default:
                System.out.println("Please type in a valid entry.");
                break;
        }
    }
}

