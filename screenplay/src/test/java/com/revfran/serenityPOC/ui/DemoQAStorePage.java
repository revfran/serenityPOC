package com.revfran.serenityPOC.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

// Main URL: "http://store.demoqa.com"
// Fallback via archive.org: "https://web.archive.org/web/20181228140401/http://store.demoqa.com/"
@DefaultUrl("https://web.archive.org/web/20181228140401/http://store.demoqa.com/")
public class DemoQAStorePage extends PageObject {
    public static Target SAMPLE_PAGE_LINK = Target.the("Sample page link")
            .locatedBy("//a[text()='Sample Page']");
}
