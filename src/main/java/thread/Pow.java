package thread;

import java.math.BigInteger;

public class Pow extends Thread {
    private int value;
    private int powValue;

    public Pow(int value, int powValue) {
        this.value = value;
        this.powValue = powValue;
    }

    public void run() {
        long pid = ProcessHandle.current().pid();
        long tid = Thread.currentThread().getId();

        System.out.println("Obliczanie " + value + " do potęgi " + powValue + " w tle...");
        BigInteger pow = calculatePow(value, powValue);
        String resultFormatted = formatResult(pow);
        System.out.println(value + " do potęgi " + powValue + " (10 pierwszych cyfr) = " + resultFormatted);
        SaveFileHelper.saveResultToFile(value + " do potęgi " + powValue + " (10 pierwszych cyfr) = " + resultFormatted, pid, tid);
    }

    private BigInteger calculatePow(int value, int powValue) {
        long powResult = (long) Math.pow(value, powValue);
        return BigInteger.valueOf(powResult);
    }

    private String formatResult(BigInteger result) {
        String resultStr = result.toString();
        if (resultStr.length() > 10) {
            return resultStr.substring(0, 10);
        } else {
            return resultStr;
        }
    }
}
