import java.util.Scanner;

public class Method {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num;
        int num2;
        System.out.println("enter a number: ");
        num = input.nextInt();
        System.out.println("enter a number: ");
        num2 = input.nextInt();
        input.nextLine();
        int sum = add(num,num2);//return of parameter of sum
        int sub =sub(num,num2);//return the parameter of sub
        int multi =multi(num,num2);//return the parameter of multi
        int divide =divide(num,num2);//return the parameter of divide
        print(sum,sub,multi,divide);     
     
    }
    static int add(int num, int num2){   
        return num+num2;
    }
       static int sub(int num, int num2){   
        return num-num2;
    }
    static int multi(int num, int num2){   
        return num*num2;
    }
     static int divide(int num, int num2){   
        return num/num2;
    }
    static void print(int a, int b, int c,int d){
        System.out.println("The sum of all numbers is "+a+
        "\nThe Difference of all numbers is "+b+
        "\nThe Product of all numbers is "+ c+
        "\nThe Division of all numbers is "+ d);
        
    }
   
}