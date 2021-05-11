package com.gotechplus;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        double annualInterestRate;
        double startingBalance;
        double monthlyInterest;
        double deposit;
        double withdraw;
        int monthPeriod;

        System.out.print("Enter the annual interest rate: ");
        // asking the user to input annual interest rate
        annualInterestRate = scan.nextDouble();
        // handling next line character (enter key)
        scan.nextLine();
        System.out.print("Enter the starting Balance: ");
        // asking the user to input the balance
        startingBalance = scan.nextDouble();
        // handling next line character (enter key)
        scan.nextLine();
        // check user input balance should be positive
        while(startingBalance <= 0){
            System.out.println("Error! invalid input!");
            System.out.print("Enter the starting balance: ");
            startingBalance = scan.nextDouble();
        }
        System.out.print("Enter the number of months that have passed since the account was established: ");
        monthPeriod = scan.nextInt();
        // handling next line character (enter key)
        scan.nextLine();
        // check the user input the month should be in [1-12]
        while(monthPeriod > 12 || monthPeriod < 1){
            System.out.println("Error! invalid input!");
            System.out.print("Enter the number of months that have passed since the account was established: ");
            monthPeriod = scan.nextInt();
        }

        SavingsAccount account = new SavingsAccount(annualInterestRate, startingBalance);

        //iterate once for every month,
        for(int month = 1; month <= monthPeriod; month++){
            System.out.println("\n-------the "
                    + month +(month == 1 ? "st" : month == 2 ? "nd" : month == 3 ? "rd" : "th")
                    + " month---------\n-----------------------------");
            System.out.print("what is the amount deposit during the "
                    + month +(month == 1 ? "st" : month == 2 ? "nd" : month == 3 ? "rd" : "th")
                    + " month: ");
            deposit = scan.nextDouble();
            // handling next line character (enter key)
            scan.nextLine();
            // adding the deposit to the account
            account.deposit(deposit);
            System.out.print("what is the amount withdrawn during the "
                    + month +(month == 1 ? "st" : month == 2 ? "nd" : month == 3 ? "rd" : "th") + " month: ");
            withdraw = scan.nextDouble();
            // handling next line character (enter key)
            scan.nextLine();
            // subtract amount from the balance
            account.withdraw(withdraw);
            //the monthly interest
            monthlyInterest = account.addInterest();
            System.out.print("monthly interest for the "
                    + month +(month == 1 ? "st" : month == 2 ? "nd" : month == 3 ? "rd" : "th")
                    + " month is: " + monthlyInterest);
        } // end for loop

        System.out.println("\n");//line break
        System.out.println("============Summary===========");
        System.out.println("your final balance is: " + account.getBalance());
        System.out.println("the total amount of deposits is: " + account.getTotalAmountOfDeposit());
        System.out.println("the total amount of withdrawals is: " + account.getTotalAmountWithdrawn());
        System.out.println("the total interest earned is: " + account.getTotalInterest());
        System.out.println("==============================");
    }

}
