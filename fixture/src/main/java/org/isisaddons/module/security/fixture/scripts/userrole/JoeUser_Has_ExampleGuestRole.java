/*
 *  Copyright 2014 Dan Haywood
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.isisaddons.module.security.fixture.scripts.userrole;

import org.isisaddons.module.security.fixture.scripts.roles.ExampleGuestRoleAndPremissions;
import org.isisaddons.module.security.fixture.scripts.users.JoeUser;

public class JoeUser_Has_ExampleGuestRole extends AbstractUserRoleFixtureScript {
    public JoeUser_Has_ExampleGuestRole() {
        super(JoeUser.USER_NAME, ExampleGuestRoleAndPremissions.ROLE_NAME);
    }
}
