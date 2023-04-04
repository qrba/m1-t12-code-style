import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period;
        int action;
        int amount;
        double newAmount = 0;
        double yearRate = 0.06;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            newAmount = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            newAmount = calculateComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за "
            + period + " лет превратятся в " + newAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
