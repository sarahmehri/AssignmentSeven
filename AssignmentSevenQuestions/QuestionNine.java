package AssignmentSevenQuestions;
/*
    Given two numbers represented by two lists,
     write a function that returns sum list.
     The sum list is list representation of addition of two input numbers.
    Suppose you have two linked list 5->4 ( 4 5 )and 5->4->3( 3 4 5)
    you have to return  a resultant linked list 0->9->3 (3 9 0).
 */
import java.util.Stack;

public class QuestionNine {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // function that calculates and prints the sum of two numbers represented
// by linked lists
    static void addTwoLists(Node l1, Node l2)
    {
        Node prev = null;
        // Create 3 stacks
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        Stack<Node> s3 = new Stack<Node>();
        // Fill first stack with first List Elements
        while (l1 != null) {
            s1.add(l1);
            l1 = l1.next;
        }
        // Fill second stack with second List Elements
        while (l2 !=null) {
            s2.add(l2);
            l2 = l2.next;
        }
        int carry = 0;
        // Fill the third stack with the sum of first and second
        // stack
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.peek().data + s2.peek().data + carry;
            Node temp = new Node(sum % 10);
            s3.add(temp);
            if (sum > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            s1.pop();
            s2.pop();
        }
        while (!s1.isEmpty()) {
            int sum = carry + s1.peek().data;
            Node temp = new Node(sum % 10);
            s3.add(temp);
            if (sum > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            s1.pop();
        }
        while (!s2.isEmpty()) {
            int sum = carry + s2.peek().data;
            Node temp = new Node(sum % 10);
            s3.add(temp);
            if (sum > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            s2.pop();
        }
        // If carry is still present create a new node with
        // value 1 and push it to the third stack
        if (carry == 1) {
            Node temp = new Node(1);
            s3.add(temp);
        }
        // Link all the elements inside third stack with each
        // other
        if (!s3.isEmpty())
            prev = s3.peek();
        while (!s3.isEmpty()) {
            Node temp = s3.peek();
            s3.pop();
            if (s3.size() == 0) {
                temp.next = null;
            }
            else {
                temp.next = s3.peek();
            }
        }
        printList(prev);
    }

    /* Utility function to print a linked list */
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("");
    }

    // Driver Code
    public static void main(String[] args) {
        QuestionNine list = new QuestionNine();

        // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List : ");
        list.printList(head1);

        // creating second list
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        System.out.print("Second List : ");
        list.printList(head2);

        System.out.print("Sum List : ");
        // add the two lists and see the result
        list.addTwoLists(head1, head2);
    }


}
/*
    Time Complextiy: O(n)
    Here n is length of the larger list
    Auxiliary Space: O(n)
    Extra space is used in storing the elements in the stack.

 */
