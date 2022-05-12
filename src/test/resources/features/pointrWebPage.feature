@PointrTech
  Feature: Deep Location Company WebPage Function Test

    @AllArticlesHaveLoaded
    Scenario: All articles on the webpage should have successfully loaded.
      Given Reading the url from the properties file and launching a new Browser
      When The driver navigate to the Webpage
      Then All the articles on the page should have loaded successfully.

    @FindAndSaveMostRepeated5WordsInLatest3ArticlesIntoTxtFile.
    Scenario: Find the most repeated 5 words in the latest 3 articles and save them (with their repeat count) into a .txt file.
      Given Reading the url from the properties file and launching a new Browser
      When The driver navigate to the Webpage
      And Find the most repeated five words in the latest three articles
      Then The most repeated five words with their repeated counts should be found correctly




