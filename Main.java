class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // INSERT at end
    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // DELETE a value
    void delete(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {

                // If head node
                if (temp.prev == null) {
                    head = temp.next;
                    if (head != null)
                        head.prev = null;
                } else {
                    temp.prev.next = temp.next;
                    if (temp.next != null)
                        temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }

        System.out.println("Value not found");
    }

    // DISPLAY list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ADD all elements
    int addition() {
        int sum = 0;
        Node temp = head;

        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }

    // SUBTRACTION (sequential)
    int subtraction() {
        if (head == null) return 0;

        int result = head.data;
        Node temp = head.next;

        while (temp != null) {
            result -= temp.data;
            temp = temp.next;
        }
        return result;
    }

    // MULTIPLICATION
    int multiplication() {
        if (head == null) return 0;

        int result = 1;
        Node temp = head;

        while (temp != null) {
            result *= temp.data;
            temp = temp.next;
        }
        return result;
    }

    // DIVISION (sequential)
    double division() {
        if (head == null) return 0;

        double result = head.data;
        Node temp = head.next;

        while (temp != null) {
            if (temp.data == 0) {
                System.out.println("Division by zero not allowed");
                return 0;
            }
            result /= temp.data;
            temp = temp.next;
        }
        return result;
    }
}

// MAIN CLASS
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insert(10);
        list.insert(5);
        list.insert(2);

        System.out.println("Doubly Linked List:");
        list.display();

        System.out.println("Addition: " + list.addition());
        System.out.println("Subtraction: " + list.subtraction());
        System.out.println("Multiplication: " + list.multiplication());
        System.out.println("Division: " + list.division());

        list.delete(5);
        System.out.println("After Deletion:");
        list.display();
    }
}