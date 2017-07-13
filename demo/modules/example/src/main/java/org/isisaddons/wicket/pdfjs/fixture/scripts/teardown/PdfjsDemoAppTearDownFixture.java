package org.isisaddons.wicket.pdfjs.fixture.scripts.teardown;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

public class PdfjsDemoAppTearDownFixture extends FixtureScript {

    @Override
    protected void execute(final ExecutionContext executionContext) {
        isisJdoSupport.executeUpdate("delete from \"isisaddonsPdfjsDemo\".\"DemoObject\"");
    }


    @javax.inject.Inject
    private IsisJdoSupport isisJdoSupport;

}