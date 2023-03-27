package practica3;

import javax.security.auth.Subject;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.activeCount;
import static java.lang.Thread.sleep;
import static jdk.jfr.internal.consumer.EventLog.stop;


public class Task3 {


    public static void main(String[] args) throws InterruptedException {

            Set<String> unSynchronizedSet = new HashSet<String>();

            unSynchronizedSet.add("apple");
            unSynchronizedSet.add("banana");
            unSynchronizedSet.add("orange");
            unSynchronizedSet.add("apple");
            unSynchronizedSet.add("qiwi");
            unSynchronizedSet.add("orange");

            Set<String> synchronizedSet = Collections.synchronizedSet(unSynchronizedSet);

            synchronized(synchronizedSet)
            {
                Iterator<String> iterator = synchronizedSet.iterator();
                while(iterator.hasNext())
                    System.out.println(iterator.next());
            }

            System.out.println("-------------");

            ExecutorService executer = Executors.newFixedThreadPool(2);
            Map<String,String> map = new HashMap<>();
            ReadWriteLock lock = new ReentrantReadWriteLock();


            executer.submit(() -> {
                lock.writeLock().lock();
                try {
                    sleep(3000);
                    map.put("key", "value1");
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally{
                    lock.writeLock().unlock();
                }
            });

            Runnable readTask = () -> {
                lock.readLock().lock();

                try {
                    System.out.println(map.get("key"));
                    sleep(1);
                }
                catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
                finally {
                    lock.readLock().unlock();

                }
            };

            executer.submit(readTask);
            executer.submit(readTask);

            executer.shutdown();
    }

}
