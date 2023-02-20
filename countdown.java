import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class countdown {

    public static void main(String[] args) {
        new countdown();
    }

    int seconds;
    boolean ifMin;
    Scanner time = new Scanner(System.in);
    Scanner min = new Scanner(System.in);
    Timer timer = new Timer();

    countdown() {
        System.out.print("How long do you want to run this?: ");
        seconds = time.nextInt();

        System.out.print("Is it in minutes?(true / false): ");
        ifMin = min.nextBoolean();
        if (ifMin) {
            seconds *= 60;
            seconds--;
        } else if (!ifMin) {
            // Thread.sleep(1000);
            System.out.print("");
        } else {
            System.out.println("Invalid input!");
            System.exit(0);
        }

        TimerTask task = new TimerTask() {
            public void run() {
                if (seconds > 0) {
                    System.out.println("Time left: " + seconds);
                    seconds--;
                    if (seconds == 0) {
                        System.out.println("Times up!");
                    }
                } else {
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
}