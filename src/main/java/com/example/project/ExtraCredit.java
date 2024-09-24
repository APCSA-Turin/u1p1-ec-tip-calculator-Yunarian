package com.example.project;
import java.util.Scanner;


public class ExtraCredit {

    public static String calculateTip(int people, int percent, double cost, String items) {
        StringBuilder result = new StringBuilder();

        // The rounding being used is the hacky rounding using int casting showcased on the slides
        // The program SHOULD only be working with positive numbers, so this should work fine
        // unrounded versions of the printed value used to simplify statements later in the program
        result.append("-------------------------------\n");
        result.append("Total bill before tip: $" + cost + "\n" ); //concatenate to this string. DO NOT ERASE AND REWRITE
        result.append("Total percentage: " + percent + "%\n");

        double unroundedTipTotal = cost / 100 * percent ;
        double tipTotal = (int)(unroundedTipTotal * 100 + 0.5) / 100.0;
        result.append("Total tip: $" + tipTotal + "\n");
        result.append("Total Bill with tip: $" + (cost + tipTotal) + "\n");

        double unroundedCostPerPerson = cost / people;
        double costPerPerson = (int)(unroundedCostPerPerson * 100 + 0.5) / 100.0;
        result.append("Per person cost before tip: $" + costPerPerson +"\n");

        double unroundedTipPerPerson = unroundedTipTotal / people;
        double tipPerPerson = (int)(unroundedTipPerPerson * 100 + 0.5) / 100.0;
        result.append("Tip per person: $" + tipPerPerson + "\n");

        double costPerPersonTotal = (int)((unroundedTipPerPerson + unroundedCostPerPerson) * 100 + 0.5) / 100.0;
        System.out.println( );

        result.append("Total cost per person: $" + costPerPersonTotal + "\n");
        result.append("-------------------------------\n");
        result.append("Items ordered:\n");
        result.append(items);

        return result.toString();
    }                        
    public static void main(String[] args) {
        int people = 6;
        int percent = 25;
        double cost = 52.27;
        String items = ""; 
        StringBuilder itemsOrdered = new StringBuilder();

        Scanner scan = new Scanner(System.in);
        System.out.print("Type what food was ordered, -1 to stop ordering. ");

        // the while loop condition is checked,
        // and if TRUE, runs the code inside.
        // when the code inside is done running, the condition is rechecked,
        // and the loop repeats as long as the condition remains TRUE.
        // when the condition becomes FALSE, it stops
        // comparing string inequalities learned from https://stackoverflow.com/questions/8484668/java-does-not-equal-not-working
        while (!items.equals("-1")) {
            items = scan.nextLine();
            if (!items.equals("-1")) {
                itemsOrdered.append(items + "\n");
            }

            if (!items.equals("-1")) {
              System.out.print("Type what food was ordered, -1 to stop ordering. ");  
            }
        }
        scan.close();

        //Your scanner object and while loop should go here
        //Converting stringBuilder to strings learned from https://www.tutorialspoint.com/converting-a-stringbuilder-to-string-in-java            
        System.out.println(calculateTip(people, percent, cost, itemsOrdered.toString()));
    }
}

