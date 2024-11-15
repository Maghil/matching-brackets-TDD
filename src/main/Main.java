package main;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        Integer inputValidity = inputValidity(input);
        switch (inputValidity) {
            case 0:
                break;
            case 1:
                System.out.println("Input is less than one character");
                break;
            case 2:
                System.out.println("Input is more than 104 characters");
                break;
            case 3:
                System.out.println("Input contains non-bracket characters");
                break;
            default:
                System.out.println("Input is valid");
        }
        if (checkMatchingBrackets(input)) {

        }
    }

    public static Integer inputValidity(String input) {

        Pattern pattern = Pattern.compile("[^{}\\[\\]()]");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return 3;
        } else if (input.length() < 1) {
            return 1;
        } else if (input.length() > 104) {
            return 2;
        }
        return 0;
    }

    public static Boolean checkMatchingBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (!isMatchingPair(last, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

}


