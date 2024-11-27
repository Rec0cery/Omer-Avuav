import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "";
        int base;
        int max1, max2;
        System.out.println("Ex1 class solution:");
        System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
        num1 = sc.next();
        if (num1 != "quit") {
            System.out.println("num1= " + num1 + " is a number: " + isNumber(num1) + ", value: " + number2Int(num1));
            if (number2Int(num1) == -1) System.out.print("ERR: num1 is in the wrong format! (" + num1 + ")");
            if (number2Int(num1) != -1) {
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                if (num2 != "quit") {
                    System.out.println("num2= " + num2 + " is a number: " + isNumber(num2) + ", value: " + number2Int(num2));
                    if (number2Int(num2) == -1) System.out.print("ERR: num2 is in the wrong format! (" + num2 + ")");
                    if (number2Int(num2) != -1) {
                        System.out.print("Enter a base for output: a number [2,16] \n");
                        base = sc.nextInt();
                        System.out.println(num1 + " + " + num2 + " = " + int2Number(number2Int(num1) + number2Int(num2), base));
                        System.out.println(num1 + " * " + num2 + " = " + int2Number(number2Int(num1) * number2Int(num2), base));

                        System.out.println("Max number over [" + num1 + "," + num2 + "," + int2Number(number2Int(num1) + number2Int(num2), base) +
                                "," + int2Number(number2Int(num1) * number2Int(num2), base) + "] is:" + int2Number(number2Int(num1) * number2Int(num2), base));

                    }
                }
            }
        }
    }
}

