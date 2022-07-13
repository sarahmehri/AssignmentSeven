package AssignmentSevenQuestions;
/*
    Given a singly linked list,
    find middle of the linked list.
    For example, if given linked list is 1->2->3->4->5
    then output should be 3
 */
public class QuestionOne {


        Node head;

        /*Creating a new Node*/
        class Node {
            int data;
            Node next;
            public Node(int data)
            {
                this.data = data;
                this.next = null;
            }
        }

        /*Function to add a new Node*/
        public void pushNode(int data)
        {
            Node new_node = new Node(data);
            new_node.next = head;
            head = new_node;
        }

        /*Displaying the elements in the list*/
        public void printNode()
        {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.print("Null"+"\n");
        }

        /*Finding the length of the list.*/
        public int getLen()
        {
            int length = 0;
            Node temp = head;
            while (temp != null) {
                length++;
                temp = temp.next;
            }
            return length;
        }

        /*Printing the middle element of the list.*/
        public void printMiddle()
        {
            if (head != null) {
                int length = getLen();
                Node temp = head;
                int middleLength = length / 2;
                while (middleLength != 0) {
                    temp = temp.next;
                    middleLength--;
                }
                System.out.print("The middle element is ["
                        + temp.data + "]");
                System.out.println();
            }
        }

        public static void main(String[] args)
        {
            QuestionOne list = new QuestionOne();
            for (int i = 5; i >= 1; i--) {
                list.pushNode(i);
                list.printNode();
                list.printMiddle();
            }
        }
    }
    /*
    Time Complexity: O(n) where n is no of nodes in linked list

    Auxiliary Space: O(1)


     */