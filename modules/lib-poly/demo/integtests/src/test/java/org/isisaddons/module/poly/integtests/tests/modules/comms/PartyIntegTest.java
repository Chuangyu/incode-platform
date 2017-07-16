package org.isisaddons.module.poly.integtests.tests.modules.comms;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.apache.isis.applib.fixturescripts.FixtureScripts;
import org.apache.isis.applib.services.wrapper.InvalidException;

import org.isisaddons.module.poly.integtests.tests.PolyAppIntegTest;

import domainapp.modules.exampledom.lib.poly.dom.democommchannel.CommunicationChannel;
import domainapp.modules.exampledom.lib.poly.dom.democommchannel.CommunicationChannels;
import domainapp.modules.exampledom.lib.poly.dom.demoparty.Party;
import domainapp.modules.exampledom.lib.poly.fixture.data.demoparty.RecreateParties;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PartyIntegTest extends PolyAppIntegTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Inject
    FixtureScripts fixtureScripts;
    @Inject
    CommunicationChannels communicationChannelsMenu;

    public static class AddCommunicationChannel extends PartyIntegTest {

        private RecreateParties fs;
        private Party party;

        @Before
        public void setUp() throws Exception {

            // given
            fs = new RecreateParties();
            fixtureScripts.runFixtureScript(fs, null);
            nextTransaction();

            party = fs.getParties().get(0);
        }

        @Test
        public void addFirst() throws Exception {

            // when
            wrap(party).addCommunicationChannel("0207 123 4567");

            // then
            List<CommunicationChannel> parties = party.getCommunicationChannels();
            assertThat(parties.size(), is(1));
            assertThat(parties.get(0).getDetails(), is("0207 123 4567"));

            parties = communicationChannelsMenu.listAll();
            assertThat(parties.size(), is(1));
        }

        @Test
        public void addSecond() throws Exception {

            // given
            wrap(party).addCommunicationChannel("0207 123 4567");

            // when
            wrap(party).addCommunicationChannel("0207 765 4321");

            // when
            List<CommunicationChannel> parties = party.getCommunicationChannels();
            assertThat(parties.size(), is(2));
            assertThat(parties.get(0).getDetails(), is("0207 123 4567"));
            assertThat(parties.get(1).getDetails(), is("0207 765 4321"));
        }

        @Test
        public void whenAlreadyExists() throws Exception {

            // given
            wrap(party).addCommunicationChannel("0207 123 4567");

            // then expect
            expectedException.expect(InvalidException.class);
            expectedException.expectMessage("Already have a communication channel with those details");

            // when
            wrap(party).addCommunicationChannel("0207 123 4567");
            nextTransaction();
        }
    }

    public static class RemoveCommunicationChannel extends PartyIntegTest {

        private RecreateParties fs;
        private Party party;

        @Before
        public void setUp() throws Exception {

            // given
            fs = new RecreateParties();
            fixtureScripts.runFixtureScript(fs, null);
            nextTransaction();

            party = fs.getParties().get(0);

            wrap(party).addCommunicationChannel("0207 123 4567");
            wrap(party).addCommunicationChannel("0207 765 4321");
        }

        @Test
        public void whenExists() throws Exception {

            // given
            List<CommunicationChannel> communicationChannels = party.getCommunicationChannels();
            assertThat(communicationChannels.size(), is(2));
            final CommunicationChannel communicationChannel = communicationChannels.get(0);

            // when
            wrap(party).removeCommunicationChannel(communicationChannel);
            nextTransaction();

            // then
            communicationChannels = party.getCommunicationChannels();
            assertThat(communicationChannels.size(), is(1));
        }
   }

}