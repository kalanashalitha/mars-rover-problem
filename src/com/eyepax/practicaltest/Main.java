package com.eyepax.practicaltest;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Maximum x cordinate of plateau :"); // 5
        int maxX = scanner.nextInt();

        System.out.println("Maximum y cordinate of plateau :"); // 5
        int maxY = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the position :");
        String initialPosition = scanner.nextLine(); //"1 2 N";

        System.out.println("Instructions to move :");
        String moveInstructions = scanner.nextLine(); //"LMLMLMLMM";

        RoverDashboard roverDashboard = new RoverDashboard(maxX, maxY);
        try {
            String output = roverDashboard.sendInstructions(initialPosition, moveInstructions);
            System.out.println("Output coordinates : " + output);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Move instructions exceed the maximum plateau x,y boundries.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
