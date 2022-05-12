package com.pointr.cucumber;

import com.pointr.TestUtility.BasePage;
import com.pointr.TestUtility.ReadFromFiles;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BasePage {

    private String chromeDriver = ReadFromFiles.readConfigProperties("chromeDriver");
    private String fireFoxDriver = ReadFromFiles.readConfigProperties("fireFox");

    @Before
    public void setUp(){
        setUpBrowser(chromeDriver);
    }

    @After
    public void tearDown(){
        teardown();
    }
}
