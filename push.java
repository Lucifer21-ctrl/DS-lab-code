import java.util.Scanner;
class Stack {

public static void main(String args[]){
Scanner sc = new Scanner(System.in);

int top = -1, value = 0;
int top1 = 1;  

System.out.println("Enter the Size of Array");
int size = sc.nextInt();

int[] arr = new int[size];   

System.out.println("Enter the values");

for(int i=0;i<size;i++){
    if(top == size - 1){
        System.out.println("Stack Overflow");
        break;
    }else{
        value = sc.nextInt();
        top++;
        arr[top] = value;
    }
}

System.out.println("Stack After Push:");
for(int i = top; i >= 0; i--)
    System.out.println(arr[i]);

if(top != -1 && arr[top] != top1){
    System.out.println("Removed Value: " + arr[top]);
    top--;   
}

System.out.println("Stack After Removal:");
if(top == -1)
    System.out.println("Stack is Empty");
else
    for(int i = top; i >= 0; i--)
        System.out.println(arr[i]);

sc.close();
}

}