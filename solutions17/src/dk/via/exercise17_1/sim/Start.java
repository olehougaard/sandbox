package dk.via.exercise17_1.sim;

import dk.via.exercise17_1.access.ElectionAccessManager;
import dk.via.exercise17_1.election.Election;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        ElectionAccessManager accessManager = new ElectionAccessManager(new Election());
        VotingSimulation votingSimulation = new VotingSimulation(accessManager);
        NewsThread news1 = new NewsThread(accessManager);
        NewsThread news2 = new NewsThread(accessManager);
        LocalNewsThread hereNews = new LocalNewsThread(accessManager, "Here");
        LocalNewsThread thereNews = new LocalNewsThread(accessManager, "There");
        LocalNewsThread everywhereNews = new LocalNewsThread(accessManager, "Everywhere");
        news1.start();
        news2.start();
        hereNews.start();
        thereNews.start();
        everywhereNews.start();
        votingSimulation.start();
        Thread.sleep(5_000);
        Election election = accessManager.requestWrite();
        try {
            election.close();
        } finally {
            accessManager.releaseWrite();
        }
    }
}
