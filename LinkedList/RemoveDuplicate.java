package LinkedList;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 3, 4, 5, 6, 6};
        Node head = convertArrToLL(arr);
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("X");

        Node newHead = removeDuplicates(head);
        Node next = newHead;
        while(next != null){
            System.out.print(next.data + "-->");
        }
    }

    private static Node removeDuplicates(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head;
        int val = head.data, count = 1;

        while(temp != null){
            if(temp.next.data != val){
                if(count == 1) break;
                else{
                    val = temp.next.data;
                    count = 1;
                }
            }
            else count++;

            temp = temp.next;
        }

        Node newHead = temp, newTemp = temp;

        while(temp != null){
            if(temp.next == null){
                if(temp.data == val) return newHead;
                else{
                    newTemp.next = temp;
                    newTemp = temp;
                }
            }
            else if(temp.next.data != val){
                if(count == 1){
                    newTemp.next = temp;
                    newTemp = temp;
                }
                else count = 1;
                val = temp.next.data;
            }
            else count++;
            temp = temp.next;
        }
        return null;
    }

    private static Node convertArrToLL(int[] arr) {
        Node head = new Node(arr[0]), temp = head;
        for(int i = 1; i < arr.length; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }
}
