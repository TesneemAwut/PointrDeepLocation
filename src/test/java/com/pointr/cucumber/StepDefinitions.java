package com.pointr.cucumber;

import com.pointr.Pages.ArticlePage;
import com.pointr.TestUtility.BasePage;
import com.pointr.TestUtility.ReadFromFiles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BasePage {

    static ArticlePage articlePage;
    private String URL;


    @Given("Reading the url from the properties file and launching a new Browser")
    public void launchingANewBrowser() {
        URL = ReadFromFiles.readConfigProperties("URL");
        articlePage = new ArticlePage(driver);
    }

    @When("The driver navigate to the Webpage")
    public void theDriverNavigateToTheWebpage() {
        driver.get(URL);
    }

    @Then("All the articles on the page should have loaded successfully.")
    public void allTheArticlesOnThePageShouldHaveLoadedSuccessfully() {
        articlePage.allArticlesLoadedCompletely();
    }

    @And("Find the most repeated five words in the latest three articles")
    public void findTheMostRepeatedWordsInTheLatestArticles() {
        articlePage.findRepeatedWordsInRecentArticles();
    }

    @Then("The most repeated five words with their repeated counts should be found correctly")
    public void theSearchResultShouldExactlyMatchWithTheExpectedResult() {
        articlePage.verifySearchResultCorrect();
    }
}
