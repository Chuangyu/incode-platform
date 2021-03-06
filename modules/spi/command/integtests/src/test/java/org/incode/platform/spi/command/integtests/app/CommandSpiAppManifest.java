package org.incode.platform.spi.command.integtests.app;

import org.apache.isis.applib.AppManifestAbstract;

import org.isisaddons.module.command.CommandModule;

import org.incode.domainapp.example.dom.spi.command.ExampleDomSpiCommandModule;

public class CommandSpiAppManifest extends AppManifestAbstract {

    public static final Builder BUILDER = Builder.forModules(
            CommandModule.class,
            ExampleDomSpiCommandModule.class
    );

    public CommandSpiAppManifest() {
        super(BUILDER);
    }

}
