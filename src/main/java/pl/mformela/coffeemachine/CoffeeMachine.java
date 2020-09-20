package pl.mformela.coffeemachine;

public class CoffeeMachine {

    private int water, milk, coffeeBeans, disposableCups, money;
    private int addedWater, addedMilk, addedCoffeeBeans, addedDisposableCups = 0;
    private machineState currentState;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
        this.currentState = machineState.CHOOSING_ACTION;
        showAvailableOptions();
    }

    public enum machineState {
        CHOOSING_ACTION, CHOOSING_COFFEE,
        ADDING_WATER, ADDING_MILK,
        ADDING_COFFEE_BEANS, ADDING_DISPOSABLE_CUPS,
    }

    private void showAvailableOptions() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
    }

    public void work(String command) {
        switch (currentState) {
            case CHOOSING_ACTION: {
                switch (command) {
                    case "take": {
                        this.money = 0;
                        System.out.println("I gave you $" + this.money);
                        showAvailableOptions();
                        break;
                    }
                    case "buy": {
                        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                        currentState = machineState.CHOOSING_COFFEE;
                        break;
                    }
                    case "fill": {
                        System.out.println("\nWrite how many ml of water do you want to add:");
                        currentState = machineState.ADDING_WATER;
                        break;
                    }
                    case "remaining": {
                        System.out.println("The coffee machine has:");
                        System.out.println(this.water + " of water");
                        System.out.println(this.milk + " of milk");
                        System.out.println(this.coffeeBeans + " of coffee beans");
                        System.out.println(this.disposableCups + " of disposable cups");
                        System.out.println(this.money + " of money");
                        showAvailableOptions();
                        break;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case CHOOSING_COFFEE: {
                switch (command) {
                    case "1": {
                        if (this.water >= 250 && this.coffeeBeans >= 16 && this.disposableCups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            this.water -= 250;
                            this.coffeeBeans -= 16;
                            this.money += 4;
                            this.disposableCups -= 1;
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (this.water < 250) {
                            System.out.println("Sorry, not enough water!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (this.coffeeBeans < 16) {
                            System.out.println("Sorry, not enough coffee beans!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (this.disposableCups < 1) {
                            System.out.println("Sorry, not enough disposable cups!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        }
                        break;
                    }
                    case "2": {
                        if (this.water >= 250 && this.coffeeBeans >= 16 && this.disposableCups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            this.water -= 350;
                            this.milk -= 75;
                            this.coffeeBeans -= 20;
                            this.money += 7;
                            this.disposableCups -= 1;
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (this.water < 350) {
                            System.out.println("Sorry, not enough water!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (this.milk < 75) {
                            System.out.println("Sorry, not enough milk!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (this.coffeeBeans < 20) {
                            System.out.println("Sorry, not enough coffee beans!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (this.disposableCups < 1) {
                            System.out.println("Sorry, not enough disposable cups!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        }
                        break;
                    }
                    case "3": {
                        if (water >= 250 && coffeeBeans >= 16 && disposableCups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            this.water -= 200;
                            this.milk -= 100;
                            this.coffeeBeans -= 12;
                            this.money += 6;
                            this.disposableCups -= 1;
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (water < 200) {
                            System.out.println("Sorry, not enough water!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (milk < 100) {
                            System.out.println("Sorry, not enough milk!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (coffeeBeans < 12) {
                            System.out.println("Sorry, not enough coffee beans!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        } else if (disposableCups < 1) {
                            System.out.println("Sorry, not enough disposable cups!");
                            this.currentState = machineState.CHOOSING_ACTION;
                            showAvailableOptions();
                        }
                        break;
                    }
                    case "back": {
                        this.currentState = machineState.CHOOSING_ACTION;
                        showAvailableOptions();
                        break;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case ADDING_WATER: {
                this.addedWater = Integer.parseInt(command);
                this.currentState = machineState.ADDING_MILK;
                System.out.println("\nWrite how many ml of milk do you want to add:");
                break;
            }
            case ADDING_MILK: {
                this.addedMilk = Integer.parseInt(command);
                this.currentState = machineState.ADDING_COFFEE_BEANS;
                System.out.println("\nWrite how many grams of coffee beans do you want to add:");
                break;
            }
            case ADDING_COFFEE_BEANS: {
                this.addedCoffeeBeans = Integer.parseInt(command);
                this.currentState = machineState.ADDING_DISPOSABLE_CUPS;
                System.out.println("\nWrite how many disposable cups do you want to add:");
                break;
            }
            case ADDING_DISPOSABLE_CUPS: {
                this.addedDisposableCups = Integer.parseInt(command);
                this.water += addedWater;
                this.milk += addedMilk;
                this.coffeeBeans += addedCoffeeBeans;
                this.disposableCups += addedDisposableCups;
                this.addedWater = 0; this.addedMilk = 0; this.addedCoffeeBeans = 0; this.addedDisposableCups = 0;
                this.currentState = machineState.CHOOSING_ACTION;
                showAvailableOptions();
                break;
            }
            default: {
                break;
            }
        }
    }
}