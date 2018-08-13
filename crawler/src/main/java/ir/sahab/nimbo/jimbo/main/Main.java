package ir.sahab.nimbo.jimbo.main;

import ir.sahab.nimbo.jimbo.crawler.CrawlSetting;
import ir.sahab.nimbo.jimbo.crawler.NewCrawler;
import ir.sahab.nimbo.jimbo.elasticsearch.ElasticCannotLoadException;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws ElasticCannotLoadException, IOException {
        Seeder.getInstance().initializeKafka();
        //(new Crawler()).run();
        try {
            new NewCrawler(new CrawlSetting(10000,
                    10000, 10000)).crawl();
            System.out.println("hello");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}