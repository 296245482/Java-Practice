package springrecruit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerAndConsumer {

    // 准备代码
    public interface Consumer{
        void consume() throws InterruptedException;
    }
    public interface Producer{
        void produce() throws InterruptedException;
    }

    abstract class AbstractConsumer implements Consumer, Runnable{
        @Override
        public void run() {
            while(true){
                try{
                    consume();
                }catch(InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
    abstract class AbstractProducer implements Producer, Runnable{
        @Override
        public void run() {
            while(true){
                try{
                    produce();
                }catch (InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public interface Model{
        Runnable newRunnableConsumer();
        Runnable newRunnableProducer();
    }
    public class Task{
        public int no;
        public Task(int no){
            this.no = no;
        }
    }

    // BlockingQueue 实现
    public class BlockingQueueModel implements Model{
        private final BlockingQueue<Task> queue;
        private final AtomicInteger increTaskNo = new AtomicInteger(0);
        public BlockingQueueModel(int cap){
            this.queue = new LinkedBlockingQueue<>(cap);
        }
        @Override
        public Runnable newRunnableConsumer() {
            return new ConsumerImpl();
        }
        @Override
        public Runnable newRunnableProducer() {
            return new ProducerImpl();
        }
        public class ConsumerImpl extends AbstractConsumer implements Consumer,Runnable{
            @Override
            public void consume() throws InterruptedException {
                Task task = queue.take();
                Thread.sleep(500+(long)(Math.random()*500));
                System.out.println("            consume:"+task.no);
            }
        }
        public class ProducerImpl extends AbstractProducer implements Producer,Runnable{
            @Override
            public void produce() throws InterruptedException{
                Thread.sleep((long)(Math.random()*1000));
                Task task = new Task(increTaskNo.getAndIncrement());
                queue.put(task);
                System.out.println("produce:"+task.no);
            }
        }

    }

    public BlockingQueueModel trans(){
        return new BlockingQueueModel(3);
    }


    public static void main (String[] args){
        ProducerAndConsumer test = new ProducerAndConsumer();
        Model model = test.trans();
        for(int i = 0; i < 2; i++){
            new Thread(model.newRunnableConsumer()).start();
        }
        for(int i = 0; i < 1; i++){
            new Thread(model.newRunnableProducer()).start();
        }
    }

}
