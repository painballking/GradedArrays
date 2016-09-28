package LinkedLists;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void insertAtBack(int value) {
        if (head == null) {
            head = new Node(value, null);
            tail = head;
        }
        else {
            Node tempref = tail;
            tail = new Node (value, null);
            tempref.setNextReference(tail);
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println ("The List is Empty");
        }
        else {
            Node tempref = head;

            System.out.println("The values so far in the list : ");
            while (tempref != null) {
                System.out.print(tempref.getData());
                tempref = tempref.getNextReference();
                if (tempref != null) {
                    System.out.print (" --> ");
                }
            }
            System.out.println("\n");
        }
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    public void insertAtFront(int input){
        if(head == null){
            head = new Node(input, null);
            tail = head;
        }
        else{
            Node tempref = head;
            head = new Node(input, tempref);
        }
    }

    public void removeFromFront(){
        if(head != null){
            head = head.getNextReference();
        }
    }

    public void removeFromBack(){
        if(head != null){
            if(head == tail){
                head = null;
            }
            else{
                Node tempref = head;
                while(tempref.getNextReference().getNextReference() != null){
                    tempref = tempref.getNextReference();
                }
                tail = tempref;
                tempref.setNextReference(null);
            }
        }
    }

    public void moveMax(){
        if(head != null){
            int maxValue = head.getData();
            Node maxReference = head;
            Node tempref = head;
            while(tempref.getNextReference() != null){
                if(tempref.getData() > maxValue){
                    maxValue = tempref.getData();
                    maxReference = tempref;
                }
                tempref = tempref.getNextReference();
            }
            if(maxReference != tail){
                tempref = head;
                Node refBeforeMaxRef = head;
                while(tempref.getNextReference() != maxReference){
                    tempref = tempref.getNextReference();
                }
            }
        }
    }

}