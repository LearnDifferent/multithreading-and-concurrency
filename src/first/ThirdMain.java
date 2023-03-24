package first;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * 执行实现了 Callable 接口的实例
 *
 * @author zhou
 * @date 2023/3/24
 */
public class ThirdMain {

    public static void main(String[] args) {
        ThirdCallable callable = new ThirdCallable();

        // Callable 接口的实现类不能直接 new Thread() 这样传入线程中
        // 这里提供 2 种方法来运行
        // 方法 1：通过 FutureTask 做一层转换
        FutureTask<Boolean> task = new FutureTask<>(callable);
        new Thread(task).start();

        // 方法 2：创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                100000, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                Executors.defaultThreadFactory(),
                new AbortPolicy());
        // 在线程池中提交任务
        Future<Boolean> submitted = executor.submit(callable);
        // 异步获取任务的结果
        try {
            Boolean result = submitted.get();
            System.out.println("打印结果为：" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 记得关闭线程池
            executor.shutdown();
        }
    }
}
