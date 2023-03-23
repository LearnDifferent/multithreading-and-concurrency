package first;

import java.util.concurrent.TimeUnit;

/**
 * 执行 {@link FirstThread} 线程的方法和 Main 方法
 *
 * @author zhou
 * @date 2023/3/23
 */
public class FirstMain {

    public static void main(String[] args) throws InterruptedException {
        // 创建 Thread 实例
        FirstThread firstThread = new FirstThread();
        // 使用 start 方法启动 Thread
        firstThread.start();

        // 执行 FirstMain 线程
        int times = 300;
        for (int i = 0; i < times; i++) {
            System.out.println("执行 "
                    + times + " 次 Main 线程的方法，现在是第 "
                    + i + " 次。在这期间会有另外一条线程执行");
            TimeUnit.MICROSECONDS.sleep(1);
        }
    }
}
