#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.incode.domainapp.example.dom.dom.alias.fixture;

import org.apache.isis.applib.fixturescripts.FixtureScript;

import org.incode.domainapp.example.dom.demo.dom.demo.DemoObject;
import org.incode.domainapp.example.dom.demo.fixture.data.DemoObjectData;
import org.incode.domainapp.example.dom.dom.alias.dom.AliasForDemoObject;
import org.incode.domainapp.example.dom.dom.alias.dom.spiimpl.aliastype.AliasTypeDemoEnum;
import org.incode.module.alias.dom.impl.T_addAlias;

public class DemoObject_withAliases_create2 extends FixtureScript {

    T_addAlias mixinAddAlias(final Object aliased) {
        return factoryService.mixin(AliasForDemoObject._addAlias.class, aliased);
    }

    @Override
    protected void execute(final ExecutionContext executionContext) {

        final DemoObject foo = DemoObjectData.Foo.findUsing(serviceRegistry);
        final DemoObject bar = DemoObjectData.Bar.findUsing(serviceRegistry);

        wrap(mixinAddAlias(foo)).${symbol_dollar}${symbol_dollar}("/uk", AliasTypeDemoEnum.GENERAL_LEDGER, "12345");
        wrap(mixinAddAlias(foo)).${symbol_dollar}${symbol_dollar}("/uk", AliasTypeDemoEnum.DOCUMENT_MANAGEMENT, "http://docserver.mycompany/url/12345");
        wrap(mixinAddAlias(foo)).${symbol_dollar}${symbol_dollar}("/uk", AliasTypeDemoEnum.PERSONNEL_SYSTEM, "12345");

        wrap(mixinAddAlias(bar)).${symbol_dollar}${symbol_dollar}("/uk", AliasTypeDemoEnum.GENERAL_LEDGER, "98765");
        wrap(mixinAddAlias(bar)).${symbol_dollar}${symbol_dollar}("/nl", AliasTypeDemoEnum.GENERAL_LEDGER, "12345");
        wrap(mixinAddAlias(foo)).${symbol_dollar}${symbol_dollar}("/nl", AliasTypeDemoEnum.DOCUMENT_MANAGEMENT, "http://docserver.mycompany/url/12345");
    }


}
