package AssignmentSevenQuestions;
/*
    Given a singly linked list, write a function to swap elements pairwise. For example,
    if the linked list is 1->2->3->4->5 then the function should change it to 2->1->4->3->5,
    and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5.
 */
public class QuestionEight {
    Node head; // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    void pairWiseSwap()
    {
        Node temp = head;

        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) {

            /* Swap the data */
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
    }

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        QuestionEight llist = new QuestionEight();

        /* Created Linked List 1->2->3->4->5 */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before calling pairWiseSwap() ");
        llist.printList();

        llist.pairWiseSwap();

        System.out.println("Linked List after calling pairWiseSwap() ");
        llist.printList();
    }
}
/*

    Time complexity: O(N)
    As we traverse the linked list only once.
    Auxiliary Space: O(1)
    As constant extra space is used.

 */