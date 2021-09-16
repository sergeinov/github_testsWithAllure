package com.github.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class githubTestsWithLambdaStep {

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

        step("Open a page " + URL, () -> {
            open(URL);
        });
        step("Enter " + REPOSITORY_NAME + " in the search field and Press ENTER", () -> {
            $("input[data-test-selector='nav-search-input']").setValue(REPOSITORY_NAME).submit();
        });
        step("Open the repository " + REPOSITORY_NAME, () -> {
            $(linkText(REPOSITORY_NAME)).click();
        });
        step("Go to Issues tab of project", () -> {
            $("#issues-tab").click();
        });
        step("Check that the page should have an Issue #" + ISSUE_NUMBER, () -> {
            $("#issue_1328").shouldHave(visible).scrollIntoView(true);
        });
        step("Check that an Issue #" + ISSUE_NUMBER + " has a title " + ISSUE_TITLE, () -> {
            $("#issue_1328").shouldHave(text(ISSUE_TITLE));
        });

    }

}
