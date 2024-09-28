package org.deneb.tp5.ejercicio3;

import java.util.concurrent.ThreadLocalRandom;
public  class Main {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReadWriteLock();
        Recurso resource = new Recurso();

        for (int i = 1; i <= 10; i++) {
            int readerId = i;
            new Thread(() -> {
                try {
                    while (true) {
                        lock.lockRead();
                        resource.read(readerId);
                        lock.unlockRead();
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                }
            }).start();
        }

        for (int i = 1; i <= 2; i++) {
            int writerId = i;
            new Thread(() -> {
                try {
                    while (true) {
                        lock.lockWrite();
                        resource.write(writerId);
                        lock.unlockWrite();
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}