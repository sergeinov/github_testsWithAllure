package com.github.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GithubTests {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void githubTest() {
        // Step 1: Open a page "https://github.com/"
        open("https://github.com/");
        // Step 2: Enter "allure-framework/allure2" in the search field and Press Enter
        $("input[data-test-selector='nav-search-input']").setValue("allure-framework/allure2").submit();
        // Step 3: Open the repository "allure-framework/allure2"
        $(linkText("allure-framework/allure2")).click();
        // Step 4: Navigate to issues of project
        $("#issues-tab").click();
        // Step 5: the page have an Issue "#1328"
        $("#issue_1328").shouldHave(visible).scrollIntoView(true);
        // Step 6:  an Issue "#1328" has a title "support Golang"
        $("#issue_1328").shouldHave(text("support Golang"));
    }

}
