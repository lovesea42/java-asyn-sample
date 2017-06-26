package async;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wangyijie on 2017/6/26.
 */
public class CompletableFutureSample {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });



        threadPool.shutdown();
    }


}
