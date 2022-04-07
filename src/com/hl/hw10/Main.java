package com.hl.hw10;

import java.util.Scanner;

import static com.hl.hw10.Field.O_SYMBOL;
import static com.hl.hw10.Field.X_SYMBOL;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        game();
        System.out.println("GAME OVER");
        while (true) {
            System.out.println("Do you want to play again?");
            System.out.println("1-yes, 2-no. Please enter you choice");
            int choice = in.nextInt();
            if (choice == 1) {
                game();
            } else if (choice == 2) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Wrong choice");
                continue;
            }
        }
    }

    public static void game() {
        Field field = new Field();
        FieldDrawer fieldDrawer = new FieldDrawer();
        fieldDrawer.draw(field);
        CoordinateValidator validator = new CoordinateValidator(1, 3);
        RandomCoordinateScanner randomCoordinateScanner = new RandomCoordinateScanner();
        CoordinateChecker coordinateChecker = new CoordinateChecker();
        DrawChecker drawChecker=new DrawChecker();
        WinChecker winChecker=new WinChecker();

        while (true) {
             do{
                Coordinate coordinate = new StdoutCoordinateScanner().scan();
                if (coordinateChecker.isCellEmpty(field, coordinate) && validator.valid(coordinate)) {
                    field.setValue(coordinate.getH() - 1, coordinate.getV() - 1, X_SYMBOL);
                    break;
                }
            }while (true);

            if (winChecker.win(X_SYMBOL, field)) {
                System.out.println("You WIN!!!");
                break;
            }
            if (drawChecker.draw(field)) {
                System.out.println("Draw!");
                break;
            }
            fieldDrawer.draw(field);
            while (true) {
                Coordinate randomCoordinate = randomCoordinateScanner.scan();
                if (coordinateChecker.isCellEmpty(field, randomCoordinate)) {
                    System.out.println(randomCoordinate);
                    field.setValue(randomCoordinate.getH()-1, randomCoordinate.getV()-1, O_SYMBOL);
                    break;
                }
            }
            fieldDrawer.draw(field);
            if (winChecker.win(O_SYMBOL, field)) {
                System.out.println("AI WIN!!!");
                break;
            } else if (drawChecker.draw(field)) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}
