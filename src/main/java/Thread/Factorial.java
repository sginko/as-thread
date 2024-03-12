package org.example;

import java.math.BigInteger;

public class Factorial extends Thread {
    private int number;

    public Factorial(int number) {
        this.number = number;
    }

    public void run() {
        long pid = ProcessHandle.current().pid();
        long tid = Thread.currentThread().getId();

        System.out.println("Obliczanie " + number + "! w tle...");
        BigInteger factorial = calculateFactorial(number);
        String resultFormatted = formatResult(factorial);
        System.out.println(number + "! (10 pierwszych cyfr) = " + resultFormatted);
        SaveFileHelper.saveResultToFile(number + "! (10 pierwszych cyfr) = " + resultFormatted, pid, tid);
    }

    private BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
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