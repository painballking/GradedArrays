package BinarySearchTrees;

public class Tree
{
    private Node root;

    public Tree()
    {
        root = null;
    }

    public Node getRoot()
    {
        return root;
    }

    public boolean isEmpty()
    {
        if (root == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public void insert(int value , Node x )
    {
        if (x == null)
        {
            root = new Node (value, null, null);
        }

        else
        {
            if ( value < x.getData())
            {
                if ( x.getLeftNodeReference() == null )
                {
                    Node y = new Node( value, null, null );
                    x.setLeftNodeReference(y);
                }
                else
                {
                    insert(value, x.getLeftNodeReference());
                }
            }

            else
            {
                if ( x.getRightNodeReference() == null )
                {
                    Node y = new Node( value, null, null );
                    x.setRightNodeReference(y);
                }
                else
                {
                    insert(value, x.getRightNodeReference());
                }
            }
        }
    }

    public void outputTree( Node currentNode, int spaces)
    {
        if (currentNode == null)
        {
            return;
        }
        else
        {
            outputTree( currentNode.getRightNodeReference(), spaces + 5 );
            for ( int k = 1; k <= spaces; k++ )
            {
                System.out.print(" ");
            }
            System.out.println( currentNode.getData() );
            outputTree( currentNode.getLeftNodeReference(), spaces + 5 );
        }
    }

    public void getMinumumValue(Node node) {
        if(node.getLeftNodeReference() == null){
            System.out.println(node.getData());
        }
        else{
            getMinumumValue(node.getLeftNodeReference());
        }
    }

    public void getMaximumValue(Node node){
        if(node.getRightNodeReference() == null){
            System.out.println(node.getData());
        }
        else{
            getMaximumValue(node.getRightNodeReference());
        }
    }

    public void printLeaves(Node node){
        if(node.getLeftNodeReference() == null && node.getRightNodeReference() == null){
            System.out.println(node.getData());
        }
        else if(node.getRightNodeReference() == null){
            printLeaves(node.getLeftNodeReference());
        }
        else if(node.getLeftNodeReference() == null){
            printLeaves(node.getRightNodeReference());
        }
        else{
            printLeaves(node.getRightNodeReference());
            printLeaves(node.getLeftNodeReference());
        }
    }

    public boolean findValue(int search, Node node){
        if(node == null){
            return false;
        }
        else{
            if(search > node.getData()){
                findValue(search, node.getRightNodeReference());
            }
            else if(search < node.getData()){
                findValue(search, node.getLeftNodeReference());
            }
            else{
                return true;
            }
        }
        return false;
    }
}
