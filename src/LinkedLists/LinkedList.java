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
        if(!this.isEmpty()){
            Node i = head;
            Node max = head;
            while(i != null){
                if(max.getData() < i.getData()){
                    max = i;
                }
                i = i.getNextReference();
            }
            if(max == head){
                this.insertAtBack(max.getData());
                head = head.getNextReference();
            }
            else if(max != tail){
                Node refBeforeMax = head;
                Node iter = head;
                while(iter != max){
                    refBeforeMax = iter;
                    iter = iter.getNextReference();
                }
                refBeforeMax.setNextReference(iter.getNextReference());
                this.insertAtBack(iter.getData());
            }
        }
    }

    public void insertionPlace(int input){
        if(this.isEmpty()){
            this.insertAtFront(input);
        }
        else{
            Node tempref = head;
            if (input < head.getData()) {
                Node store = head;
                head = new Node(input, store);
            }
            else{
                while(tempref != null && tempref.getData() < input){
                    tempref = tempref.getNextReference();
                }
                if(tempref == null){
                    this.insertAtBack(input);
                }
                else{
                    tempref.setNextReference(new Node(input, tempref.getNextReference()));
                }
            }
        }
    }

    public void bubbleSort(){
        if (!this.isEmpty()) {
            Node current = head;
            while (current.getNextReference() != null) {
                if (current.getData() < current.getNextReference().getData()) {

                }
            }
        }
    }
}