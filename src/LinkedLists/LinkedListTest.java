package LinkedLists;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedListTest {

    private static int index = 0;
    private static ArrayList<LinkedList> lists = new ArrayList<LinkedList>();

    public static void printMainMenu(){
        System.out.println("1 - Insertion functions");
        System.out.println("2 - Removal functions");
        System.out.println("3 - Modifier functions");
        System.out.println("4 - Select working list");
        System.out.println("0 - Quit");
        System.out.println();
    }

    public static boolean mainMenu(int choice, LinkedList list){
        switch(choice){
            case 1:
                printInsertMenu();
                while(!insertMenu(getInt(false), list))
                    printInsertMenu();
                return true;
            case 2:
                printRemoveMenu();
                while(!removeMenu(getInt(false), list))
                    printRemoveMenu();
                return true;
            case 3:
                printModifierMenu();
                while(!modifierMenu(getInt(false), list))
                    printModifierMenu();
                return true;
            case 4:
                printSelectMenu();
                while(!selectMenu(getInt(false)))
                    printSelectMenu();
                return true;
            case 0:
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid entry. Try again.\n");
                return true;
        }
    }

    public static void printInsertMenu(){
        System.out.println("1 - Insert at back");
        System.out.println("2 - Insert at front");
        System.out.println("3 - Insert based on value");
        System.out.println("0 - Back");
        System.out.println();
    }

    public static boolean insertMenu(int choice, LinkedList list){
        switch(choice){
            case 1:
                list.insertAtBack(getInt(true));
                return true;
            case 2:
                list.insertAtFront(getInt(true));
                return true;
            case 3:
                list.insertionPlace(getInt(true));
                return true;
            case 0:
                return true;
            default:
                System.out.println("Invalid Entry. Try Again.\n");
                return false;
        }
    }

    public static void printRemoveMenu(){
        System.out.println("1 - Remove from back");
        System.out.println("2 - Remove from front");
        System.out.println("0 - Back");
        System.out.println();
    }

    public static boolean removeMenu(int choice, LinkedList list){
        switch(choice){
            case 1:
                list.removeFromBack();
                return true;
            case 2:
                list.removeFromFront();
                return true;
            case 0:
                return true;
            default:
                System.out.println("Invalid Entry. Try Again.\n");
                return false;
        }
    }


    public static void printModifierMenu(){
        System.out.println("1 - Move max to back");
        System.out.println("2 - Bubble sort");
        System.out.println("0 - Back");
        System.out.println();
    }

    public static boolean modifierMenu(int choice, LinkedList list){
        switch(choice){
            case 1:
                list.moveMax();
                return true;
            case 2:
                list.bubbleSort();
                return true;
            case 0:
                return true;
            default:
                System.out.println("Invalid entry. Try Again.\n");
                return false;
        }
    }

    public static void printSelectMenu(){
        System.out.println("1 - Add new linked list");
        System.out.println("2 - Choose linked list");
        System.out.println("3 - Print lists");
        System.out.println("0 - Back");
        System.out.println();
    }

    public static boolean selectMenu(int choice){
        switch(choice){
            case 1:
                lists.add(new LinkedList());
                for(int i=0; i<lists.size(); i++){
                    System.out.print("List " + (i+1) + ": ");
                    lists.get(i).printList();
                }
                System.out.println();
                return true;
            case 2:
                for(int i=0; i<lists.size(); i++){
                    System.out.print("List " + (i+1) + ": ");
                    lists.get(i).printList();
                }
                System.out.println();
                System.out.print("Choice: ");
                int newIndex = getInt(false);
                if(newIndex >= 0 && newIndex < lists.size()){
                    index = newIndex;
                    return true;
                }
                else{
                    System.out.println("List does not exist");
                    return false;
                }
            case 3:
                for(int i=0; i<lists.size(); i++){
                    System.out.print("List " + (i+1) + ": ");
                    lists.get(i).printList();
                }
                System.out.println();
                return true;
            default:
                System.out.println("Invalid entry. Try again.\n");
                return false;
        }
    }

    public static int getInt(boolean printOption){
        if(printOption){
            System.out.print("Value: ");
        }
        boolean gotGoodValue = false;
        int choice = 0;
        while(!gotGoodValue) {
            gotGoodValue = true;
            try {
                choice = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (Exception e) {
                System.out.println("Integers only. Try again.\n");
                gotGoodValue = false;
            }
        }
        return choice;
    }

    public static void main (String args []) {
        lists.add(new LinkedList());

        do{
            System.out.print("Current list: ");
            lists.get(index).printList();
            printMainMenu();
        } while(mainMenu(getInt(false), lists.get(index)));
    }
}