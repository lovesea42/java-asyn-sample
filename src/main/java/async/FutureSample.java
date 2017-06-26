package async;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wangyijie on 2017/6/26.
 */
public class FutureSample {

    ExecutorService threadPool = Executors.newSingleThreadExecutor();

    Future<Integer> future = threadPool.submit(new Callable<Integer>() {
        public Integer call() throws Exception {
            return new Random().nextInt(100);
        }
    });

    //阻塞实现
    public void block(){

        System.out.println("start...");
        try {
            System.out.println("end:" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //非阻塞实现
    public void nonBlock(){

        while (true) {
            if (future.isDone()) {
                try {
                    System.out.println("finished:" + future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                break;
            } else
                System.out.println("not ok:");
        }


        threadPool.shutdown();
    }

    public static void main(String[] args) {
        FutureSample sample = new FutureSample();
        //sample.block();
        sample.nonBlock();
    }

}
