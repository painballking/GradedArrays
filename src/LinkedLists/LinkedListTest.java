package LinkedLists;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedListTest {

    private static int index = 0;
    private static ArrayList<LinkedList> lists = new ArrayList<>();

    private static boolean mainMenu(LinkedList list){
        System.out.println("       Main Menu");
        System.out.println("-----------------------");
        System.out.println("1 - Insertion functions");
        System.out.println("2 - Removal functions");
        System.out.println("3 - Modifier functions");
        System.out.println("4 - Select working list");
        System.out.println("0 - Quit");
        System.out.println();

        int choice = getInt("");
        switch(choice){
            case 1:
                while(!insertMenu(list));
                return true;

            case 2:
                while(!removeMenu(list));
                return true;

            case 3:
                while(!modifierMenu(list));
                return true;

            case 4:
                while(!selectMenu());
                return true;

            case 0:
                System.out.println("Exiting...");
                return false;

            default:
                System.out.print("Invalid entry. Try again.\n\n");
                return true;
        }
    }

    private static boolean insertMenu(LinkedList list){
        System.out.println("      Insertion Menu");
        System.out.println("-------------------------");
        System.out.println("1 - Insert at back");
        System.out.println("2 - Insert at front");
        System.out.println("3 - Insert based on value");
        System.out.println("0 - Back");
        System.out.println();

        int choice = getInt("");
        switch(choice){
            case 1:
                list.insertAtBack(getInt("Value: "));
                return true;

            case 2:
                list.insertAtFront(getInt("Value: "));
                return true;

            case 3:
                list.insertionPlace(getInt("Value: "));
                return true;

            case 0:
                return true;

            default:
                System.out.print("Invalid Entry. Try Again.\n\n");
                return false;
        }
    }

    private static boolean removeMenu(LinkedList list){
        System.out.println("    Removal Menu");
        System.out.println("---------------------");
        System.out.println("1 - Remove from back");
        System.out.println("2 - Remove from front");
        System.out.println("0 - Back");
        System.out.println();

        int choice = getInt("");
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

    private static boolean modifierMenu(LinkedList list){
        System.out.println("    Modifier Menu");
        System.out.println("--------------------");
        System.out.println("1 - Move max to back");
        System.out.println("2 - Bubble sort");
        System.out.println("3 - Merge lists");
        System.out.println("0 - Back");
        System.out.println();

        int choice = getInt("");
        switch(choice){
            case 1:
                list.moveMax();
                return true;

            case 2:
                list.bubbleSort();
                return true;

            case 3:
                System.out.println("Available Lists");
                for(int i=0; i<lists.size(); i++){
                    System.out.print("List " + (i+1) + ": ");
                    lists.get(i).printList();
                }
                LinkedList list1 = lists.get((getInt("List 1: ")-1));
                LinkedList list2 = lists.get((getInt("List 2: ")-1));
                lists.remove(list1);
                lists.remove(list2);
                lists.add(merge(list1, list2));
                System.out.println("\nNew list " + (lists.size()));
                lists.get(lists.size()-1).printList();
                index = lists.size()-1;
                return true;

            case 0:
                return true;

            default:
                System.out.print("Invalid entry. Try Again.\n\n");
                return false;
        }
    }

    private static boolean selectMenu(){
        System.out.println("    Selection Menu");
        System.out.println("-----------------------");
        System.out.println("1 - Add new linked list");
        System.out.println("2 - Choose linked list");
        System.out.println("3 - Print lists");
        System.out.println("0 - Back");
        System.out.println();

        int choice = getInt("");
        switch(choice){
            case 1:
                System.out.println("Added list " + (lists.size()+1) + ". Current lists:");
                lists.add(new LinkedList());
                for(int i=0; i<lists.size(); i++){
                    System.out.print("List " + (i+1) + ": ");
                    lists.get(i).printList();
                }
                return true;

            case 2:
                System.out.println("Available Lists");
                for(int i=0; i<lists.size(); i++){
                    System.out.print("List " + (i+1) + ": ");
                    lists.get(i).printList();
                }
                int newIndex = getInt("Choice: ")-1;
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

    private static int getInt(String printOption){
        if(!printOption.equals("")){
            System.out.print(printOption);
        }
        boolean gotGoodValue = false;
        int choice = 0;
        while(!gotGoodValue) {
            try {
                choice = Integer.parseInt(new Scanner(System.in).nextLine());
                gotGoodValue = true;
            } catch (Exception e) {
                System.out.println("Integers only. Try again.\n");
                gotGoodValue = false;
            }
        }
        return choice;
    }

    private static LinkedList merge(LinkedList list1, LinkedList list2){
        LinkedList ret = new LinkedList();

        while(!list1.isEmpty() || !list2.isEmpty()){
            if(list1.isEmpty()){
                ret.insertAtBack(list2.pop());
            }
            else if(list2.isEmpty()){
                ret.insertAtBack(list1.pop());
            }
            else if(list1.getFrontData() > list2.getFrontData()){
                ret.insertAtBack(list2.pop());
            }
            else{
                ret.insertAtBack(list1.pop());
            }
        }
        return ret;
    }

    public static void main (String args []) {
        lists.add(new LinkedList());

        do{
            System.out.print("Current list: ");
            lists.get(index).printList();
        } while(mainMenu(lists.get(index)));
    }
}