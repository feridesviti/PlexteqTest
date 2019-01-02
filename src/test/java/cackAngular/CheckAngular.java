package cackAngular;

import angular.AngularMainPage;
import angular.GettingStartedPage;
import base.BaseTest;
import helper.YamlHelper;
import helper.YamlReader;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class CheckAngular extends BaseTest {
    private static int countResalt;
    private AngularMainPage mainPage = new AngularMainPage(driver);
    private GettingStartedPage gettingStartedPage = new GettingStartedPage(driver);

    @BeforeClass
    public static void before() throws IOException {
        YamlReader reader = new YamlReader();
        Map<String, Integer> params = reader.read("C:\\Users\\Slobodyan\\Documents\\test\\src\\test\\resource\\angularParams.yaml");
        countResalt = params.get("countResalt");
    }

    @Test
    public void checkStartedButton(){
        mainPage.openMainPage()
                .clickOnStartedButton();
        gettingStartedPage.checkTitle("Getting started");
    }

    @Test
    public void checkSearch(){
        mainPage.openMainPage()
                .search("test")
                .checkCountSearchResult(countResalt);
    }

}
