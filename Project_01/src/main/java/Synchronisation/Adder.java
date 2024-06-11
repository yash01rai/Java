package Synchronisation;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Count c;
    private Lock lock;

    public Adder(Count count, Lock lock) {
        this.c = count;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 0; i < 100; i++) {
            lock.lock();

            this.c.count += i;
            System.out.println("Adding " + i);

            lock.unlock();
        }

        return null;
    }
}
