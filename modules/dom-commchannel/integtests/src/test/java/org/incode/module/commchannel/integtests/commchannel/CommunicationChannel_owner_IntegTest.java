package org.incode.module.commchannel.integtests.commchannel;

import java.util.SortedSet;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import org.incode.module.commchannel.dom.impl.channel.CommunicationChannel;
import org.incode.module.commchannel.dom.impl.channel.CommunicationChannelRepository;
import org.incode.module.commchannel.dom.impl.channel.CommunicationChannel_owner;
import domainapp.modules.exampledom.module.commchannel.dom.demo.CommChannelDemoObject;
import domainapp.modules.exampledom.module.commchannel.dom.demo.CommChannelDemoObjectMenu;
import domainapp.modules.exampledom.module.commchannel.fixture.CommChannelDemoObjectsTearDownFixture;
import org.incode.module.commchannel.integtests.CommChannelModuleIntegTestAbstract;

import static org.assertj.core.api.Assertions.assertThat;

public class CommunicationChannel_owner_IntegTest extends CommChannelModuleIntegTestAbstract {

    @Inject
    CommChannelDemoObjectMenu commChannelDemoObjectMenu;
    @Inject
    CommunicationChannelRepository communicationChannelRepository;

    CommChannelDemoObject fredDemoOwner;
    CommChannelDemoObject billDemoOwner;

    SortedSet<CommunicationChannel> fredChannels;
    SortedSet<CommunicationChannel> billChannels;

    CommunicationChannel_owner mixinOwner(final CommunicationChannel channel) {
        return mixin(CommunicationChannel_owner.class, channel);
    }

    @Before
    public void setUpData() throws Exception {
        fixtureScripts.runFixtureScript(new CommChannelDemoObjectsTearDownFixture(), null);

        fredDemoOwner = wrap(commChannelDemoObjectMenu).create("Fred");
        wrap(mixinNewEmailAddress(fredDemoOwner))
                .$$("fred@gmail.com", "Home Email", "Fred Smith's home email");
        wrap(mixinNewEmailAddress(fredDemoOwner))
                .$$("fred.smith@somecompany.com", "Work Email", "Fred Smith's work email");
        fredChannels = communicationChannelRepository.findByOwner(fredDemoOwner);
        assertThat(fredChannels).hasSize(2);

        billDemoOwner = wrap(commChannelDemoObjectMenu).create("Bill");
        wrap(mixinNewEmailAddress(billDemoOwner))
                .$$("bill@yahoo.com", "Home Email", "Bill Jones' home email");
        billChannels = communicationChannelRepository.findByOwner(billDemoOwner);
        assertThat(billChannels).hasSize(1);
    }

    public static class ActionImplementationIntegrationTest extends CommunicationChannel_owner_IntegTest {

        @Test
        public void happy_case() throws Exception {
            for (final CommunicationChannel channel : fredChannels) {
                final CommunicationChannel_owner owner = mixinOwner(channel);
                assertThat(owner.$$()).isSameAs(fredDemoOwner);
            }
        }

    }



}