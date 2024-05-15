package com.example.seleniumtesting;

import com.example.seleniumtesting.service.ScraperService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SeleniumTestingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SeleniumTestingApplication.class, args);

        ScraperService scraperService = context.getBean(ScraperService.class);

        scraperService.scrapeFromUserInput();

        context.close();
    }
}
