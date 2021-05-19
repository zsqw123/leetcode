public class Main {
    public static void main(String[] args) {
        Object l0 = new Object(), l1 = new Object();
        new Thread(() -> {
            try {
                synchronized (l0) {
                    Thread.sleep(200);
                    synchronized (l1) {
                        System.out.println("got lock1");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                synchronized (l1) {
                    Thread.sleep(100);
                    synchronized (l0) {
                        System.out.println("got lock0");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
