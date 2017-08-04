package org.incode.platform.dom.tags.integtests;

import org.junit.BeforeClass;

import org.apache.isis.core.integtestsupport.IntegrationTestAbstract2;

import org.incode.domainapp.example.dom.demo.ExampleDemoSubmodule;
import org.incode.platform.dom.tags.integtests.app.TagsModuleAppManifest;

public abstract class TagsModuleIntegTestAbstract extends IntegrationTestAbstract2 {

    @BeforeClass
    public static void initClass() {
        bootstrapUsing(TagsModuleAppManifest.BUILDER
                .withAdditionalModules(ExampleDemoSubmodule.class)
        );
    }

}
