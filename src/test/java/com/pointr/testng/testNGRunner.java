package com.pointr.testng;

import com.pointr.Pages.ArticlePage;
import com.pointr.TestUtility.BasePage;
import com.pointr.TestUtility.Log;
import com.pointr.TestUtility.ReadFromFiles;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGRunner extends BasePage {

    private String URL = ReadFromFiles.readConfigProperties("URL");
    private String chromeDriver = ReadFromFiles.readConfigProperties("chromeDriver");
    private String fireFoxDriver = ReadFromFiles.readConfigProperties("fireFox");
    static ArticlePage articlePage;


    @BeforeTest
    public void browserSetUp(){
        setUpBrowser(chromeDriver);
        articlePage = new ArticlePage(driver);
    }

    @BeforeMethod
    public void navigateToWebpage(){
        driver.get(URL);
        Log.info("Pointr blog website is opened");
    }

    @Test (priority = 1)
    public void AllArticlesLoadedCompletely(){
        Log.startTestCase("Verify All Articles Loaded Completely");
        Assert.assertTrue(articlePage.allArticlesLoadedCompletely());
        Log.endTestCase("Verify All Articles Loaded Completely");
    }

    @Test (priority = 2 )
    public void FindMostReapedFiveWordsInThreeArticle(){
        Log.startTestCase("Find Most Reaped Five Words In Three Article");
        articlePage.findRepeatedWordsInRecentArticles();
        Assert.assertTrue(articlePage.verifySearchResultCorrect());
        Log.endTestCase("Find Most Reaped Five Words In Three Article");
    }

    @AfterTest
    public void tearDown(){
        teardown();
    }
}
