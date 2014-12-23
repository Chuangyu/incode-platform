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
package org.isisaddons.module.security.seed.scripts;

import org.isisaddons.module.security.dom.tenancy.ApplicationTenancies;
import org.isisaddons.module.security.dom.tenancy.ApplicationTenancy;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public abstract class AbstractTenancyFixtureScript extends FixtureScript {


    protected ApplicationTenancy create(
            final String name,
            final String path,
            final String parentPath,
            final ExecutionContext executionContext) {

        final ApplicationTenancy parent = parentPath != null? applicationTenancies.findTenancyByPath(parentPath): null;
        applicationTenancy = applicationTenancies.newTenancy(name, path, parent);
        executionContext.addResult(this, name, applicationTenancy);
        return applicationTenancy;
    }

    private ApplicationTenancy applicationTenancy;

    /**
     * The {@link org.isisaddons.module.security.dom.tenancy.ApplicationTenancy} created by this fixture.
     */
    public ApplicationTenancy getApplicationTenancy() {
        return applicationTenancy;
    }

    @javax.inject.Inject
    private ApplicationTenancies applicationTenancies;

}
