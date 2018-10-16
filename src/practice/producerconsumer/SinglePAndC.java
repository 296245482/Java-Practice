package practice.producerconsumer;

import java.util.ArrayList;

/**
 * 但生产者消费者，wait/notify实现。容量只有1，size=0生产，=1消费
 */
public class SinglePAndC {
    private static final Object lock = new Object();
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        new ConsumerThread().start();
        new ProducerThread().start();
    }

    private static class ProducerThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (lock) {
                    while (list.size() != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add("food");
                    System.out.println(getName() + "：生产一个元素");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            }
        }
    }

    private static class ConsumerThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (lock) {
                    if (list.size() == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.remove(0);
                    System.out.println(getName() + "：消费一个元素");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            }
        }
    }
}
