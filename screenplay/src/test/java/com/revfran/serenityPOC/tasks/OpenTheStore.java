package com.revfran.serenityPOC.tasks;

import com.revfran.serenityPOC.ui.DemoQAStorePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheStore implements Task {

    DemoQAStorePage demoQAStorePage;

    @Step("Open the store")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(demoQAStorePage)
        );
    }
}
