package org.incode.platform.dom.alias.integtests.app.fixtures;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.fixturescripts.FixtureScripts;
import org.apache.isis.applib.services.fixturespec.FixtureScriptsSpecification;
import org.apache.isis.applib.services.fixturespec.FixtureScriptsSpecificationProvider;
import org.incode.domainapp.example.dom.dom.alias.fixture.AliasDemoObjectsFixture;

/**
 * Specifies where to find fixtures, and other settings.
 */
@DomainService(nature = NatureOfService.DOMAIN)
public class AliasDemoObjectsFixturesSpecificationProvider implements FixtureScriptsSpecificationProvider {

    @Override
    public FixtureScriptsSpecification getSpecification() {
        return FixtureScriptsSpecification
                .builder(AliasDemoObjectsFixturesSpecificationProvider.class)
                .with(FixtureScripts.MultipleExecutionStrategy.EXECUTE)
                .withRunScriptDefault(AliasDemoObjectsFixture.class)
                .withRunScriptDropDown(FixtureScriptsSpecification.DropDownPolicy.CHOICES)
                .withRecreate(AliasDemoObjectsFixture.class)
                .build();
    }
}