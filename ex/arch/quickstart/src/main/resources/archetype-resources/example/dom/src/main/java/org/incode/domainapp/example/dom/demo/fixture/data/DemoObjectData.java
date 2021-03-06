#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.incode.domainapp.example.dom.demo.fixture.data;

import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.services.registry.ServiceRegistry2;

import org.incode.domainapp.example.dom.demo.dom.demo.DemoObject;
import org.incode.module.fixturesupport.dom.data.DemoData;
import org.incode.module.fixturesupport.dom.data.DemoDataPersistAbstract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(chain = true)
public enum DemoObjectData implements DemoData<DemoObjectData, DemoObject> {

    Foo("Foo"),
    Bar("Bar"),
    Baz("Baz"),
    Foz("Foz"),
    ;

    private final String name;

    @Programmatic
    public DemoObject asDomainObject() {
        return DemoObject.builder()
                .name(name)
                .build();
    }

    @Programmatic
    public DemoObject persistUsing(final ServiceRegistry2 serviceRegistry) {
        return Util.persist(this, serviceRegistry);
    }

    @Programmatic
    public DemoObject findUsing(final ServiceRegistry2 serviceRegistry) {
        return Util.firstMatch(this, serviceRegistry);
    }

    public static class PersistScript extends DemoDataPersistAbstract<PersistScript, DemoObjectData, DemoObject> {
        public PersistScript() {
            super(DemoObjectData.class);
        }
    }

}
