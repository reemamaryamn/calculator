import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first number: ");
                int num1 = Integer.parseInt(input.nextLine());

                System.out.print("Enter second number: ");
                int num2 = Integer.parseInt(input.nextLine());

                System.out.println("Available operations are:");
                String[] operations = {"Addition", "+", "Subtraction", "-", "Multiplication", "*", "Division", "/", "%", "**", "//", "exit"};
                for (String op: operations) {
                    System.out.println(op);
                }

                System.out.print("What operation do you want to use? ");
                String operator = input.nextLine();

                if (operator.equalsIgnoreCase("exit")) {
                    System.out.println("Calculator exited.");
                    break;
                }

                double result = 0;
                boolean valid = true;

                switch (operator) {//similar to if else
                    case "Addition":
                    case "+":
                        result = num1 + num2;
                        break;
                    case "Subtraction":
                    case "-":
                        result = num1 - num2;
                        break;
                    case "Multiplication":
                    case "*":
                        result = num1 * num2;
                        break;
                    case "Division":
                    case "/":
                        if (num2 != 0)
                            result = (double) num1 / num2;
                        else {
                            System.out.println("Cannot divide by zero.");
                            valid = false;
                        }
                        break;
                    case "%":
                        result = num1 % num2;
                        break;
                    case "**":
                        result = Math.pow(num1, num2);
                        break;
                    case "//":
                        if (num2 != 0)
                            result = num1 / num2;
                        else {
                            System.out.println("Cannot divide by zero.");
                            valid = false;
                        }
                        break;
                    default://else
                        System.out.println("Invalid operation!");
                        valid = false;
                }

                if (valid) {
                    System.out.println("Result: " + result);
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid integers!");
            }
        }

        input.close();
    }
}

