package first;

/**
 * 创建一个线程，并运行 {@link SecondRunnable} 的实现
 *
 * @author zhou
 * @date 2023/3/23
 */
public class SecondMain {

    public static void main(String[] args) {
        // new 一个 Runnable 实现的实例
        SecondRunnable runnable = new SecondRunnable();
        // 创建线程实例，并传入 Runnable 实现的实例
        Thread thread = new Thread(runnable);
        thread.start();

        // 上面的代码等同于下面的代码
        new Thread(runnable).start();
    }
}
