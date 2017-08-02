package org.incode.domainapp.example.dom.spi.security.fixture.userrole;

import org.incode.domainapp.example.dom.spi.security.fixture.users.JoeUser;
import org.isisaddons.module.security.seed.scripts.IsisModuleSecurityRegularUserRoleAndPermissions;

public class JoeUser_Has_IsisSecurityModuleRegularRole extends AbstractUserRoleFixtureScript {
    public JoeUser_Has_IsisSecurityModuleRegularRole() {
        super(JoeUser.USER_NAME, IsisModuleSecurityRegularUserRoleAndPermissions.ROLE_NAME);
    }
}