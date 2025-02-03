package DataStructure.LinkedList;

public class ReverseInKGroups {

    // Logic to Reverse given linked list from temp to Kth Node
    private Node reverse(Node head){
        if(head == null || head.next == null) return head;

        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // Logic to find Kth Node from temp Node
    private Node findKthNode(Node temp, int k){
        k--;

        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }

        return temp;
    }

    // Logic to reverse linked list in K groups

    public Node reverseKGroup(Node head, int k) {
        // If head is null or k is 1 then return head
        if (head == null || k == 1) return head;

        Node temp = head;
        // Take a prev node to keep track of previous node and to connect the reversed linked list
        Node prev = null;

        while(temp != null){
            Node kthNode = findKthNode(temp, k);

            if(kthNode == null){
                // If kth node is null then connect the previous node to temp node and break the loop
                if(prev != null) prev.next = temp;

                break;
            }
            
            // Point one node ahead of kth node for next iteration
            Node nextNode = kthNode.next;
            // Disconnect the kth node from the linked list to reverse the linked list from temp to kth node
            kthNode.next = null;
            Node reversedHead = reverse(temp);
            

            // If prev is null then it means we are at the beginning of the linked list so update the head
            if(prev == null){
                head = reversedHead;
            }

            // else connect the previous node to the reversed linked list
            else{
                prev.next = reversedHead;
            }


            // Connect the reversed linked list to the next node
            prev = temp;
            temp = nextNode;
        }

        return head;
    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
