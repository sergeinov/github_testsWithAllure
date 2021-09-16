package com.github.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class githubTestsWithAnnotatedStep {

    private final static String REPOSITORY_NAME = "allure-framework/allure2";
    private final static String URL = "https://github.com/";
    private final static Integer ISSUE_NUMBER = 1328;
    private final static String ISSUE_TITLE = "support Golang";

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void githubTest() {

        WebSteps steps = new WebSteps();
        steps.openMainPage(URL);
        steps.searchForRepository(REPOSITORY_NAME);
        steps.openRepository(REPOSITORY_NAME);
        steps.openIssueTab();
        steps.checkIssue(ISSUE_NUMBER);
        steps.checkIssueTitle(ISSUE_TITLE);

    }

}
