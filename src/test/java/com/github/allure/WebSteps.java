package com.github.allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open a page {Url}")
    public void openMainPage(String Url) {
        open(Url);
    }

    @Step("Enter {repositoryName}  in the search field and Press ENTER")
    public void searchForRepository(String repositoryName) {
        $("input[data-test-selector='nav-search-input']").setValue(repositoryName).submit();
    }

    @Step("Open the repository {repositoryName}")
    public void openRepository(String repositoryName) {
        $(linkText(repositoryName)).click();
    }

    @Step("Go to Issues tab of project")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Check that the page should have an Issue #{issueNumber}")
    public void checkIssue(Integer issueNumber) {
        $("#issue_" + issueNumber).shouldHave(visible).scrollIntoView(true);
    }

    @Step("Check that an issue  has a title {issueTitle}")
    public void checkIssueTitle(String issueTitle) {
        $("#issue_1328").shouldHave(text(issueTitle));
    }

}
