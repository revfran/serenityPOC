package com.revfran.serenityPOC.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillField implements Task {
    private FillField fillField;
    private final Target target;
    private String value;

    public FillField(Target target){this.target = target; }
    protected FillField(Target target,String value){this(target); this.value = value;}



    @Step("{0} fills the field '#target' with value '#value'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.value)
                        .into(this.target)
        );
    }

    public static FillField fillTheField( Target target) {
        return new FillField(target);
    }

    public FillField withTheValue( String value) {
        return instrumented(FillField.class, this.target, value);
    }
}
