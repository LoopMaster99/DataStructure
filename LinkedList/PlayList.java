package LinkedList;

import java.util.Scanner;

public class PlayList {
    private static Node reverse(Node head){
        if(head.next == null) return head;

        Node newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine(); // Consume newline after nextInt()

        Node head = new Node("", "");
        Node temp = head;
        for(int i = 0; i < n; i++){
            String title = scan.nextLine();
            String artist = scan.nextLine();

            Node newNode = new Node(title, artist);
            temp.next = newNode;
            temp = newNode;
        }
        head = head.next;

        System.out.println();
        System.out.println("Playlist created successfully");
        System.out.println();
        System.out.println("Playing song from the beginning");

        Node mover = head;

        while(mover != null){
            System.out.println("Playing: " + mover.title + " - " + mover.artist);
            mover = mover.next;
        }

        System.out.println();
        System.out.println("Playing song from the end");

        Node newHead = reverse(head);
        mover = newHead;

        while(mover != null){
            System.out.println("Playing: " + mover.title + " - " + mover.artist);
            mover = mover.next;
        }
        scan.close();
    }
}

class Node{
    String title;
    String artist;
    Node next;

    Node(String title, String artist){
        this.title = title;
        this.artist = artist;
        this.next = null;
    }
}
