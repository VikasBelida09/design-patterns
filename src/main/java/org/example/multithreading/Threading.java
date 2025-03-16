package org.example.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threading {
    private double balance = 0.0;

    // Synchronized write operations ensure that deposits and withdrawals
    // are performed atomically.
    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
    }

    // getBalance() is not synchronized—so while one thread writes,
    // another thread might read an outdated or intermediate value.
    public double getBalance() {
        return balance;
    }
    public static void main(String[] args) throws InterruptedException {
        Threading account = new Threading();

        // Task for depositing money: deposit $10, 1000 times.
        Runnable depositTask = () -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(10);
                // Optionally, sleep a tiny bit to exaggerate the effect.
                // try { Thread.sleep(1); } catch (InterruptedException e) { }
            }
        };

        // Task for withdrawing money: withdraw $10, 1000 times.
        Runnable withdrawTask = () -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(10);
                // try { Thread.sleep(1); } catch (InterruptedException e) { }
            }
        };

        // Task for reading the balance concurrently.
        Runnable readTask = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Balance read: " + account.getBalance());
                // try { Thread.sleep(1); } catch (InterruptedException e) { }
            }
        };

        // Start threads for deposit, withdrawal, and reading balance concurrently.
        Thread t1 = new Thread(depositTask);
        Thread t2 = new Thread(withdrawTask);
        Thread t3 = new Thread(readTask);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final balance (unsynchronized read): " + account.getBalance());
    }
}
