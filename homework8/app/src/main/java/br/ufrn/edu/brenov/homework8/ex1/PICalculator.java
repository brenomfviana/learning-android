package br.ufrn.edu.brenov.homework8.ex1;

public class PICalculator implements Runnable {

    private double pi;

    @Override
    public void run() {
        double sum = 0;
        this.pi = 0;
        for(int i = 1; i <= 100000; i++) {
            sum += (Math.pow(-1, i + 1)) / (2 * i - 1);
        }
        this.pi = sum * 4;
    }

    public double get() {
        return this.pi;
    }
}
