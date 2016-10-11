package BinarySearchTrees;


import java.util.Scanner;

public class TreeTest2 {

    public static void Menu()
    {
        System.out.println("1 - Insert a Value ");
        System.out.println("10- Input Stream; -1 to stop");
        System.out.println("2 - Print the Tree");
        System.out.println("3 - Print path to value");
        System.out.println("4 - Most Expensive path");

        System.out.println("0 - Quit");
    }

    public static void main (String args [])
    {
        System.out.println ("Binary Search Trees");
        Scanner scanner = new Scanner (System.in);
        Scanner scanner1 = new Scanner (System.in);

        Tree tree = new Tree ();
        boolean flag = true;
        int status = 0, choice = 0;

        while (flag)
        {
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
                System.out.println ("Input Value");
                int input = scanner1.nextInt();
                tree.insert (input, tree.getRoot());
            }
            else if(choice == 10){
                int input = scanner1.nextInt();
                while(input != -1){
                    tree.insert(input, tree.getRoot());
                    input = scanner1.nextInt();
                }

            }
            else if (choice == 2) {
                if (tree.isEmpty())
                {
                    System.out.println ("The Tree is Empty");
                }
                else
                {
                    tree.outputTree(tree.getRoot(),0);
                }
            }
            else if (choice == 3) {
                if (tree.isEmpty()) {
                    System.out.println ("The Tree is Empty");
                }
                else {
                    System.out.println ("Input Value");
                    int value = scanner1.nextInt();
                    if(!tree.findValue(value, tree.getRoot())){
                        System.out.println (value + " is not in the tree ");
                    }
                    else{
                        System.out.println ("Path :");
                        tree.path(value, tree.getRoot());
                    }
                }
            }
            else if(choice == 4){
                System.out.println(
            }
            else if(choice == 5){
                tree = new Tree();
                System.out.println("Tree reset");
            }

            else {
                if (choice == 0) {
                    flag = false;
                    System.out.println("End of Program");
                } else if (status == 0) {
                    System.out.println("Invalid Entry - Enter Again");
                }
            }
            System.out.println ("\n");

        }
    }
}