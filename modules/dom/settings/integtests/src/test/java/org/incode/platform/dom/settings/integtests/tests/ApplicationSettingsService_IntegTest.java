package org.incode.platform.dom.settings.integtests.tests;

import java.util.List;
import org.isisaddons.module.settings.dom.ApplicationSetting;
import org.isisaddons.module.settings.dom.ApplicationSettingsServiceRW;
import org.incode.platform.dom.settings.integtests.SettingsModuleIntegTestAbstract;

import org.incode.domainapp.example.dom.dom.settings.fixture.ApplicationSetting_and_UserSetting_recreate5;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationSettingsService_IntegTest extends SettingsModuleIntegTestAbstract {

    @Before
    public void setUpData() throws Exception {
        scenarioExecution().install(new ApplicationSetting_and_UserSetting_recreate5());
    }

    @javax.inject.Inject
    private ApplicationSettingsServiceRW applicationSettingsServiceRW;

    @Test
    public void listAll() throws Exception {

        final List<ApplicationSetting> all = wrap(applicationSettingsServiceRW).listAll();
        assertThat(all.size(), is(5));
    }
    

}