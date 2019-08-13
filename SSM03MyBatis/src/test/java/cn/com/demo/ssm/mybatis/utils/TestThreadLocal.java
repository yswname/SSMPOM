package cn.com.demo.ssm.mybatis.utils;

public class TestThreadLocal {
    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        local.set("张鑫");

        new Thread() {
            public void run() {
                String name2 = local.get();
                System.out.println("Thread。。。。。Name=" + name2);
            }
        }.start();

        String name = local.get();
        System.out.println("******name=" + name);
        Thread.sleep(3000);
    }
}
