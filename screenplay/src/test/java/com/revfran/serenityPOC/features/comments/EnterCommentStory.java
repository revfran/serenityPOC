package com.revfran.serenityPOC.features.comments;

import com.revfran.serenityPOC.tasks.FillField;
import com.revfran.serenityPOC.tasks.Navigate;
import com.revfran.serenityPOC.tasks.OpenTheStore;
import com.revfran.serenityPOC.tasks.Push;
import com.revfran.serenityPOC.ui.SamplePage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class EnterCommentStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = false)
    public WebDriver herBrowser;

    @Steps
    OpenTheStore openTheStore;
    Navigate navigate;
    FillField fillField;
    Push push;


    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void wrong_email_should_show_an_error_message() {

        givenThat(anna).wasAbleTo(openTheStore);

        when(anna).attemptsTo(navigate.toSamplePage());

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("Sample Page"))));

        when(anna).attemptsTo(fillField.fillTheField(SamplePage.NAME).withTheValue("Anna"));

        when(anna).attemptsTo(fillField.fillTheField(SamplePage.COMMENT).withTheValue("Sample comment"));

        when(anna).attemptsTo(fillField.fillTheField(SamplePage.EMAIL).withTheValue("some_wrong_email"));

        when(anna).attemptsTo(push.submitComment());

        // Should be adjusted to the error message but no access to source page
        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("Wayback Machine"))));
    }

    @Test
    public void right_email_should_show_a_confirmation_message() {

        givenThat(anna).wasAbleTo(openTheStore);

        when(anna).attemptsTo(navigate.toSamplePage());

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("Sample Page"))));

        when(anna).attemptsTo(fillField.fillTheField(SamplePage.NAME).withTheValue("Anna"));

        when(anna).attemptsTo(fillField.fillTheField(SamplePage.COMMENT).withTheValue("Sample comment"));

        when(anna).attemptsTo(fillField.fillTheField(SamplePage.EMAIL).withTheValue("anna@demoqa.com"));

        when(anna).attemptsTo(push.submitComment());

        // Should be adjusted to the confirmation message but no access to source page -> staying on same page as OK
        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("Sample Page"))));
    }
}