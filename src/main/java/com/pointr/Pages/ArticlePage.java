package com.pointr.Pages;
import com.pointr.TestUtility.Log;
import com.pointr.TestUtility.ReadFromFiles;
import com.pointr.TestUtility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class ArticlePage {
    static String pageLoadStatus = null;
    JavascriptExecutor js;
    WebDriver driver;
    Utility utility;
    public List<String> content;
    public Map<String, Integer> sorted;

    @FindBy(xpath = "//article[@class='post-body']/span")
    WebElement articleContentField;

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new Utility(driver);
    }

    public boolean allArticlesLoadedCompletely() {
        do {
            js = (JavascriptExecutor) driver;
            pageLoadStatus = (String) js.executeScript("return document.readyState");
        } while (!pageLoadStatus.equals("complete"));
        Log.info("All articles loaded completely");
        return true;
    }

    public void findRepeatedWordsInRecentArticles(){
        content = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<WebElement> recentArticle = driver.findElements(By.cssSelector("#new-blog-test > section > article"));
            recentArticle.get(i).click();
            utility.waitForElementPresent(articleContentField);
            String articleContent = articleContentField.getText();
            content.addAll(Arrays.asList(articleContent.split(" ")));
            driver.navigate().back();
        }
        String[] words = content.toArray(new String[0]);
            HashMap<String, Integer> wordMap = new HashMap<>();
            for (String word : words) {
                wordMap.put(word, (wordMap.get(word) == null ? 1 : (wordMap.get(word) + 1)));
            }
            Log.info("Most repeated 5 words in recent 3 article are:");
            sorted = wordMap.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue()))
                    .limit(5).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

            for (String s : sorted.keySet()) {
                System.out.println(s + " " + sorted.get(s));
                try
                {
                    String filename= "MyFile.txt";
                    FileWriter fileWriter = new FileWriter(filename,true);
                    PrintWriter printWriter= new PrintWriter(fileWriter);
                    {
                        printWriter.println(s + " " + sorted.get(s));
                        printWriter.close();
                    }

                }
                catch(IOException ioe)
                {
                    System.err.println("IOException: " + ioe.getMessage());
                }

            }
        }

    public boolean verifySearchResultCorrect(){
        Map<String, Integer> expectedResult = ReadFromFiles.getHashMapWithProperties();
        System.out.println(expectedResult);
        if(expectedResult.equals(sorted))
        {
            Log.info("Search result equals to expected result");
        }else {
            Log.info("Search result does not equal to expected result");
            return false;
        }
        return true;
    }

    }


