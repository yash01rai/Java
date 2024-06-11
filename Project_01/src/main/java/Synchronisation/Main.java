package Synchronisation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // instances
        Count c = new Count();
        Lock lock = new ReentrantLock(); //mutex

        Adder adder = new Adder(c, lock);
        Subtractor subtractor = new Subtractor(c, lock);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> addFuture = es.submit(adder);
        Future<Void> subtractFuture = es.submit(subtractor);

        addFuture.get();
        subtractFuture.get();


        System.out.println(c.count);


    }
}
