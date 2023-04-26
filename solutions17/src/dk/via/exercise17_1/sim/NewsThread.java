package dk.via.exercise17_1.sim;

import dk.via.exercise17_1.access.ElectionAccessManager;
import dk.via.exercise17_1.voting.News;

import java.util.Random;

public class NewsThread extends Thread {
    private final News news;

    public NewsThread(ElectionAccessManager accessManager) {
        news = new News(accessManager);
    }

    @SuppressWarnings({"BusyWait"})
    @Override
    public void run() {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(1000));
            while(true) {
                boolean isOpen = news.report();
                if (!isOpen) break;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
