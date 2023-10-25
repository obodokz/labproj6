import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите номер задачи: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1: bank();
            case 2: credit(); break;
            default: System.out.print("Ошибка");
        }
    }
    public static void bank() {
        int[] denominations = {1000, 500, 100, 50, 10, 5, 1}; // Доступные номиналы купюр
        int[] counts = new int[denominations.length]; // Количество купюр каждого номинала

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму для выдачи: ");
        int amount = scanner.nextInt();

        for (int i = 0; i < denominations.length; i++) {
            int denomination = denominations[i];
            counts[i] = amount / denomination; // Количество купюр данного номинала
            amount %= denomination; // Оставшаяся сумма
        }

        System.out.println("Выдача купюр:");
        for (int i = 0; i < denominations.length; i++) {
            if (counts[i] > 0) {
                System.out.println(denominations[i] + " рублей: " + counts[i] + " купюр");
            }
        }
    }
    public static void credit() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму кредита: ");
        double loanAmount = scanner.nextDouble();

        System.out.print("Введите годовую процентную ставку (в процентах): ");
        double annualInterestRate = scanner.nextDouble() / 100;

        System.out.print("Введите срок кредита (в годах): ");
        int years = scanner.nextInt();

        int numberOfMonths = years * 12;
        double monthlyInterestRate = annualInterestRate / 12;
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfMonths));
        double totalCost = monthlyPayment * numberOfMonths;

        System.out.println("Ежемесячный платеж: " + monthlyPayment);
        System.out.println("Стоимость кредита: " + totalCost);
    }
}