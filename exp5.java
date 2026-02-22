import java.util.Scanner;

public class Experiment5 {
    static int stack[];
    static int top = -1;

    static void push(int value){
        if(top == stack.length - 1){
            System.out.println("Stack Overflow");
        } else {
            top++;
            stack[top] = value;
            System.out.println("pushed: " + value);
        }
    }

    static void pop(){
        if(top == -1){
            System.out.println("Stack is underflow");
        } else {
            System.out.println("poped = " + stack[top]);
            top--;
        }
    }
    static void peck(){
        if(top == -1){
            System.out.println("stack is empty");
        } else {
            System.out.println("Top element = " + stack[top]);
        }
    }

    static void display(){
        if(top == -1){
            System.out.println("Stack Empty");
        }

        System.out.print("Stack :");
        for(int i = top; i >= 0; i--){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack Size :");
        int n = sc.nextInt();
        stack = new int[n];

        int choice;
        int value;

        do{
            System.out.println("\nEnter Which operation you perform :");
            System.out.println("================================");
            System.out.println("1. Push");
            System.out.println("2. pop");
            System.out.println("3. peck");
            System.out.println("4. Display");
            System.out.println("0. Exit");
            System.out.println("=================================");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter value to push: ");
                    value = sc.nextInt();
                    push(value);
                    break;

                case 2:
                    pop();
                    break;
                
                case 3:
                    peck();
                    break;

                case 4:
                    display();
                    break;
            }

        }while(choice != 0);

        sc.close();
    }
}