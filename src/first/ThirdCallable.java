package first;

import java.util.concurrent.Callable;

/**
 * 通过实现 callable 接口，将其放入线程中执行。
 * Callable 可以有返回值，可以抛出异常
 *
 * @author zhou
 * @date 2023/3/24
 */
public class ThirdCallable implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        int times = 200;
        for (int i = 0; i < times; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " 线程一共需要执行 " + times
                    + " 次方法，当前是第 " + i + " 次");
        }
        return true;
    }
}