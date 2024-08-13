package Java_2.Assignment5.MessingAbout;

public class MessingRunnable implements Runnable{

    private final String data;
    public MessingRunnable(String data) {
        this.data = data;
    }

    @Override
    public void run() {
        checkMess();
    }

    public void checkMess() {
        System.out.println("RUNNING");
        System.out.println(this.data);
    }
}
