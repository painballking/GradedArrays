package LinkedLists;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedListTest {

    public static void printMainMenu(){
        System.out.println("1 - Insertion functions");
        System.out.println("2 - Removal functions");
        System.out.println("3 - Modifier functions");
        System.out.println("4 - Select working list");
        System.out.println("0 - Quit");
    }

    public static boolean mainMenu(int choice, LinkedList list){
        switch(choice){
            case 1:
                printInsertMenu();
                while(!insertMenu(getInt(), list));
                return true;
            default:
                return false;
        }
    }

    public static void printInsertMenu(){
        System.out.println("1 - Insert at back");
        System.out.println("2 - Insert at front");
        System.out.println("3 - Insert based on value");
        System.out.println("0 - Back");
    }

    public static boolean insertMenu(int choice, LinkedList list){
        switch(choice){
            case 1: list.insertAtBack(getValue());
            case 2: list.insertAtFront(getValue());
            case 3: list.insertionPlace(getValue());
                    return true;
            default:
                System.out.println("Invalid Entry. Try Again.");
                return false;
        }
    }

    public static void printRemoveMenu(){
        System.out.println("1 - Remove from back");
        System.out.println("2 - Remove from front");
        System.out.println("0 - Back");
    }

    public static void printModifierMenu(){
        System.out.println("1 - Move max to back");
        System.out.println("2 - Bubble sort");
        System.out.println("0 - Back");
    }

    public static int getValue(){
        System.out.print("Enter the value: ");
        boolean gotGoodValue = false;
        int choice = 0;
        while(!gotGoodValue) {
            gotGoodValue = true;
            try {
                choice = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (Exception e) {
                System.out.println("Integers only. Try again.");
                gotGoodValue = false;
            }
        }
        return choice;
    }

    public static int getInt(){
        boolean gotGoodValue = false;
        int choice = 0;
        while(!gotGoodValue) {
            gotGoodValue = true;
            try {
                choice = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (Exception e) {
                System.out.println("Integers only. Try again.");
                gotGoodValue = false;
            }
        }
        return choice;
    }

    public static void main (String args []) {
        Scanner input = new Scanner(System.in);
        int status, choice = 0;

        ArrayList<LinkedList> lists = new ArrayList<LinkedList>();
        LinkedList list = new LinkedList();

        while(true){
            printMainMenu();
            mainMenu(getInt(), list);
            list.printList();
        }
    }
}