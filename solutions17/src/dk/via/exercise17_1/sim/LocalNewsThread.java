package dk.via.exercise17_1.sim;

import dk.via.exercise17_1.access.ElectionAccessManager;
import dk.via.exercise17_1.voting.LocalNews;

import java.util.Random;

public class LocalNewsThread extends Thread {
    private final LocalNews news;

    public LocalNewsThread(ElectionAccessManager accessManager, String county) {
        news = new LocalNews(accessManager, county);
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
