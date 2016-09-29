package LinkedLists;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedListTest {

    public static void mainMenu(){
        System.out.println("1 - Insertion functions");
        System.out.println("2 - Removal functions");
        System.out.println("3 - Modifier functions");
        System.out.println("4 - Select working list");
        System.out.println("0 - Quit");
    }

    public static void insertMenu(){
        System.out.println("1 - Insert at back");
        System.out.println("2 - Insert at front");
        System.out.println("3 - Insert based on value");
        System.out.println("0 - Back");
    }

    public static void removeMenu(){
        System.out.println("1 - Remove from back");
        System.out.println("2 - Remove from front");
        System.out.println("0 - Back");
    }

    public static void modifierMenu(){
        System.out.println("1 - Move max to back");
        System.out.println("2 - Bubble sort");
        System.out.println("0 - Back");
    }

    public static void main (String args []) {
        Scanner input = new Scanner(System.in);

        ArrayList<LinkedList> lists = new ArrayList<LinkedList>();

        while(true){
            mainMenu();
            int choice = input.nextInt();

            switch(choice){
                case 1:
                    Scanner temp = new Scanner(System.in);
                    insertMenu();
                    switch
            }
        }
    }
}