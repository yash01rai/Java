package Synchronisation;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
        private Count c;
        private Lock lock;

        public Subtractor(Count count, Lock lock) {
            this.c = count;
            this.lock = lock;
        }

        @Override
        public Void call() throws Exception {
            for (int i = 0; i < 100; i++) {
                lock.lock();

                this.c.count -= i;
                System.out.println("Subtracting " + i);

                lock.unlock();
            }

            return null;
        }
}
