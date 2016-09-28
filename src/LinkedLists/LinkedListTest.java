package LinkedLists;

import java.util.Scanner;

public class LinkedListTest
{

    public static void Menu()
    {
        System.out.println ("1 - Insert At Back ");
        System.out.println ("2 - Insert At Front");
        System.out.println ("3 - Remove From Front");
        System.out.println ("4 - Remove From Back");
        System.out.println ("5 - Move max to back");
        System.out.println ("6 - Quit");
    }


    public static void main (String args [])
    {
        System.out.println ("Linked Lists");
        Scanner scanner = new Scanner (System.in);
        Scanner scanner1 = new Scanner (System.in);


        int choice = 0, status = 0, entry = 0;
        boolean flag = true;
        LinkedList list = new LinkedList();

        while (flag) {
            Menu();
            status = 0;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println("Integers Only - Enter Again");
                status = 1;
            }

            if (choice == 1) {
                System.out.println ("Enter the value?");
                entry = scanner1.nextInt();
                list.insertAtBack(entry);
            }

            else if (choice == 2) {
                System.out.println ("Enter the value?");
                entry = scanner1.nextInt();
                list.insertAtFront(entry);
            }
            else if (choice == 3) {
                list.removeFromFront();
            }

            else if (choice == 4) {
                list.removeFromBack();
            }
            else if(choice == 5){
                list.moveMax();
            }
            else if (choice == 6) {
                flag = false;
                System.out.println ("End of Program");
            }

            else if (status == 0)
            {
                System.out.println ("Invalid Entry - Choose From Menu");
            }
            list.printList();
        }

    }
}