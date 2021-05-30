package calculator;

import java.util.Scanner;

public class Calculator {

    int add (int a, int b) {
        return a + b;
    }

    int subtract (int a, int b) {
        return a - b;
    }

    int multiply (int a, int b) {
        return a * b;
    }

    int divide (int a, int b) {
        return a / b;
    }

    String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    int getResult(String inputVal) {

        String[] values = inputVal.split(" ");

        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length - 1; i = i+2) {
            result = calculate(result, values[i], Integer.parseInt(values[i+1]));
        }

        return result;
    }

    int calculate(int a, String operand, int b) {

        switch(operand) {
            case "+":
                return add(a,b);
            case "-":
                return subtract(a,b);
            case "*":
                return multiply(a,b);
            case "/":
                return divide(a,b);
            default :
                return 0;
        }
    }

}
