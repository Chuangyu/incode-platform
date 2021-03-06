#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.incode.domainapp.example.dom.spi.command.dom.demo.color;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Mixin;

import org.incode.domainapp.example.dom.spi.command.dom.demo.SomeCommandAnnotatedObject;

@Mixin
public class SomeCommandAnnotatedObj_updateCopyOfColorBySubscribedBackgrndMixinAct {

    public static class ActionDomainEvent
            extends org.apache.isis.applib.services.eventbus.ActionDomainEvent <SomeCommandAnnotatedObj_updateCopyOfColorBySubscribedBackgrndMixinAct> {}

    private final SomeCommandAnnotatedObject someCommandAnnotatedObject;

    public SomeCommandAnnotatedObj_updateCopyOfColorBySubscribedBackgrndMixinAct(SomeCommandAnnotatedObject someCommandAnnotatedObject) {
        this.someCommandAnnotatedObject = someCommandAnnotatedObject;
    }

    @Action(domainEvent = SomeCommandAnnotatedObj_updateCopyOfColorBySubscribedBackgrndMixinAct.ActionDomainEvent.class)
    public SomeCommandAnnotatedObject ${symbol_dollar}${symbol_dollar}(final SomeCommandAnnotatedObject.Colour colour) {
        someCommandAnnotatedObject.setCopyOfColorUpdatedBySubscribedBackgroundMixinAction(colour);
        return someCommandAnnotatedObject;
    }

    public SomeCommandAnnotatedObject.Colour default0${symbol_dollar}${symbol_dollar}() {
        return someCommandAnnotatedObject.getColour();
    }

}
