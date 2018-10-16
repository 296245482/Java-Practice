package practice.producerconsumer;

import java.util.ArrayList;

/**
 * 多消费者模型，wait/notify实现
 * 多消费者，避免多人消费导致空指针产生，改ConsumerThread中的if为while；避免消费者唤醒消费者，消费者的notify()使用notifyAll()
 */
public class MultiPAndC {
    private static ArrayList<String> list = new ArrayList<>();
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new ProducerThread().start();
        for (int i = 0; i < 3; i++) {
            new ConsumerThread().start();
        }
    }

    private static class ProducerThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (lock) {
                    if (list.size() != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add("food");
                    System.out.println(getName() + "：生产一个元素，现有元素个数：" + list.size());
                    try {
                        Thread.sleep(10000);
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
                    while (list.size() == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.remove(0);
                    System.out.println(getName() + "：消费一个元素，现有元素个数：" + list.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        }
    }
}
