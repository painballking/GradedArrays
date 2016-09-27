package LinkedLists;

import java.util.Scanner;

public class LinkedListTest
{

    public static void Menu()
    {
        System.out.println ("1 - Insert At Back ");
        System.out.println ("2 - Quit");
    }


    public static void main (String args [])
    {
        System.out.println ("Linked Lists");
        Scanner scanner = new Scanner (System.in);
        Scanner scanner1 = new Scanner (System.in);

        int choice = 0, status = 0, entry = 0;
        boolean flag = true;
        LinkedList list = new LinkedList();

        while (flag)
        {

            Menu();
            status = 0;

            try
            {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("Integers Only - Enter Again");
                status = 1;
            }

            if (choice == 1)
            {
                System.out.println ("Enter the value?");
                entry = scanner1.nextInt();
                list.insertAtBack(entry);
            }
            else if (choice == 2)
            {
                flag = false;
                System.out.println ("End of Program");
            }

            else if (status == 0)
            {
                System.out.println ("Invalid Entry - Enter Again");
            }
            list.printList();
            System.out.println("\b");
        }

    }
}