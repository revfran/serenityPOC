package com.revfran.serenityPOC.tasks;

import com.revfran.serenityPOC.ui.DemoQAStorePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {

    @Override
    @Step("Clicks on sample page link")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DemoQAStorePage.SAMPLE_PAGE_LINK));
    }

    public static Navigate toSamplePage() {
        return instrumented(Navigate.class);
    }
}
