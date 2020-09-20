package pl.mformela.coffeemachine;

import pl.mformela.coffeemachine.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachineClient {
    public static void main(String[] args) {
        boolean detectedExitCommand = false;
        String userCommand;
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);
        while (!detectedExitCommand) {
            userCommand = scanner.next();
            if (userCommand.equals("exit")) {
                detectedExitCommand = true;
                System.out.println("Exiting...");
                break;
            }
            coffeeMachine.work(userCommand);
        }
    }
}
