package com.example.seleniumtesting.service;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class ScraperService {
    private static final String TABLE_SELECTOR = "table";

    private final ChromeDriver driver;

    public void scrapeFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the URL to scrape: ");
            String url = scanner.nextLine();
            driver.get(url);
            WebElement table = driver.findElement(By.cssSelector(TABLE_SELECTOR));

            List<WebElement> rows = table.findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + "\t");
                }
                System.out.println();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Table not found.");
        } finally {
            driver.quit();
            scanner.close();
        }
    }
}
