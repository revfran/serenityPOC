package com.revfran.serenityPOC.tasks;

import com.revfran.serenityPOC.ui.SamplePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Push implements Task {

    @Override
    @Step("Clicks on sample page link")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SamplePage.POST_COMMENT));
    }

    public static Push submitComment() {
        return instrumented(Push.class);
    }
}
