#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.incode.domainapp.example.dom.spi.command.dom.demo.desc;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.CommandReification;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.incode.domainapp.example.dom.spi.command.dom.demo.SomeCommandAnnotatedObject;

@Mixin
public class SomeCommandAnnotatedObject_changeDescription {

    private final SomeCommandAnnotatedObject someCommandAnnotatedObject;

    public SomeCommandAnnotatedObject_changeDescription(SomeCommandAnnotatedObject someCommandAnnotatedObject) {
        this.someCommandAnnotatedObject = someCommandAnnotatedObject;
    }

    @Action(
            semantics = SemanticsOf.IDEMPOTENT,
            command = CommandReification.ENABLED
    )
    public SomeCommandAnnotatedObject ${symbol_dollar}${symbol_dollar}(
            @Parameter(optionality = Optionality.OPTIONAL)
            @ParameterLayout(named = "Description")
            final String description) {
        someCommandAnnotatedObject.setDescription(description);
        return someCommandAnnotatedObject;
    }

    public String default0${symbol_dollar}${symbol_dollar}() {
        return someCommandAnnotatedObject.getDescription();
    }

}
