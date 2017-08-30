#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.incode.domainapp.example.dom.dom.tags.fixture.data;

public class DemoTaggableObject_Bar_Pepsi_Drink extends AbstractTaggableObjectFixture {

    @Override
    protected void execute(ExecutionContext executionContext) {
        create("Bar", "Pepsi", "Drink", executionContext);
    }

}
