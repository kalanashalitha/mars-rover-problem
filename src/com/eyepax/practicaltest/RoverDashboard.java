package com.eyepax.practicaltest;

public class RoverDashboard {

    enum CompassPoints {N, E, S, W}

    private boolean[][] plateauGrid;
    private int roverCurrentX;
    private int roverCurrentY;
    private CompassPoints roverCurrentHeading;

    RoverDashboard(int maxX, int maxY) {
        plateauGrid = new boolean[maxY + 1][maxX + 1];
    }

    String sendInstructions(String initialGridPosition, String instructionsToMove) {
        setInitialGridPosition(initialGridPosition);
        move(instructionsToMove);

        if (plateauGrid[roverCurrentY][roverCurrentX])
            return roverCurrentX + " " + roverCurrentY + " " + roverCurrentHeading;
        else
            return "Rover operation failed";

    }

    private void setInitialGridPosition(String initialGridPosition) {
        String[] coordinates = initialGridPosition.split(" ");
        if (3 == coordinates.length) {
            roverCurrentX = Integer.parseInt(coordinates[0]);
            roverCurrentY = Integer.parseInt(coordinates[1]);
            roverCurrentHeading = CompassPoints.valueOf(coordinates[2]);
        } else {
            throw new IllegalArgumentException("Incorrect position coordinates");
        }
    }

    private void move(String instructions) throws ArrayIndexOutOfBoundsException {
        for (char instruction : instructions.toCharArray()) {
            if ('L' == instruction) {
                switch (roverCurrentHeading) {
                    case N:
                        roverCurrentHeading = CompassPoints.W;
                        break;
                    case E:
                        roverCurrentHeading = CompassPoints.N;
                        break;
                    case S:
                        roverCurrentHeading = CompassPoints.E;
                        break;
                    case W:
                        roverCurrentHeading = CompassPoints.S;
                }
            } else if ('R' == instruction) {
                switch (roverCurrentHeading) {
                    case N:
                        roverCurrentHeading = CompassPoints.E;
                        break;
                    case E:
                        roverCurrentHeading = CompassPoints.S;
                        break;
                    case S:
                        roverCurrentHeading = CompassPoints.W;
                        break;
                    case W:
                        roverCurrentHeading = CompassPoints.N;
                }
            } else if ('M' == instruction) {

                switch (roverCurrentHeading) {
                    case N:
                        plateauGrid[roverCurrentY][roverCurrentX] = false;
                        plateauGrid[++roverCurrentY][roverCurrentX] = true;
                        break;
                    case E:
                        plateauGrid[roverCurrentY][roverCurrentX] = false;
                        plateauGrid[roverCurrentY][++roverCurrentX] = true;
                        break;
                    case S:
                        plateauGrid[roverCurrentY][roverCurrentX] = false;
                        plateauGrid[--roverCurrentY][roverCurrentX] = true;
                        break;
                    case W:
                        plateauGrid[roverCurrentY][roverCurrentX] = false;
                        plateauGrid[roverCurrentY][--roverCurrentX] = true;
                }

            } else {

                throw new IllegalArgumentException("Unrecognized instruction");
            }
        }
    }
}
