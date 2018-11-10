package br.ufrn.edu.brenov.homework8.ex2;

public class Randomizer implements Runnable {

    private volatile boolean running;
    private double number;

    @Override
    public void run() {
        this.running = true;
        while (this.running) {
            generate();
        }
    }

    public void stop() {
        this.running = false;
    }

    private synchronized void generate() {
        this.number = Math.random();
    }

    public synchronized double getNumber() {
        return this.number;
    }
}
