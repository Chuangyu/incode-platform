package org.incode.platform.dom.settings.integtests.app;

import org.apache.isis.applib.AppManifestAbstract;

import org.isisaddons.module.settings.SettingsModule;

import org.incode.domainapp.example.dom.dom.settings.ExampleDomModuleSettingsModule;

public class SettingsModuleAppManifest extends AppManifestAbstract {

    public static final Builder BUILDER =
            Builder.forModules(
                    SettingsModule.class,
                    ExampleDomModuleSettingsModule.class,
                    SettingsAppModule.class);

    public SettingsModuleAppManifest() {
        super(BUILDER);
    }

}
