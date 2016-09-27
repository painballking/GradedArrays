package LinkedLists;

public class LinkedList
{
    private Node head;
    private Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void insertAtBack(int word)
    {
        if (head == null)
        {
            head = new Node(word, null);
            tail = head;
        }
        else
        {
            Node tempref = tail;
            tail = new Node (word, null);
            tempref.setNextReference(tail);
        }
    }

    public void printList()
    {
        if (head == null)
        {
            System.out.println ("The List is Empty");
        }
        else
        {
            Node tempref = head;
            System.out.println("The values so far in the list : ");
            while (tempref != null)
            {
                System.out.print(tempref.getData());
                tempref = tempref.getNextReference();
                if (tempref != null)
                {
                    System.out.print (" --> ");
                }
            }
            System.out.println("\n");
        }
    }

}