package com.revfran.serenityPOC.ui;
import net.serenitybdd.screenplay.targets.Target;

public class SamplePage {
    public static Target NAME = Target.the("Name field")
            .locatedBy("//input[@name='author']");
    public static Target EMAIL = Target.the("Email field")
            .locatedBy("//input[@name='email']");
    public static Target COMMENT = Target.the("Comment field")
            .locatedBy("//textarea[@name='comment']");
    public static Target POST_COMMENT = Target.the("Post comment button")
            .locatedBy("//input[@name='submit']");

}
