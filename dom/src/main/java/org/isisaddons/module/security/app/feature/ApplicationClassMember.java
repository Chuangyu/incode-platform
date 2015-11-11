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
package org.isisaddons.module.security.app.feature;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.ViewModelLayout;

import org.isisaddons.module.security.dom.feature.ApplicationFeatureId;

@ViewModelLayout(
        bookmarking = BookmarkPolicy.AS_CHILD
)
public abstract class ApplicationClassMember extends ApplicationFeatureViewModel {

    public static abstract class PropertyDomainEvent<S extends ApplicationClassMember, T> extends ApplicationFeatureViewModel.PropertyDomainEvent<ApplicationClassMember, T> {}

    public static abstract class CollectionDomainEvent<S extends ApplicationClassMember, T> extends ApplicationFeatureViewModel.CollectionDomainEvent<S, T> {}

    public static abstract class ActionDomainEvent<S extends ApplicationClassMember> extends ApplicationFeatureViewModel.ActionDomainEvent<S> {}

    // //////////////////////////////////////

    //region > constructors
    public ApplicationClassMember() {
    }

    public ApplicationClassMember(final ApplicationFeatureId featureId) {
        super(featureId);
    }
    //endregion

    //region > memberName (properties)

    public static class MemberNameDomainEvent extends PropertyDomainEvent<ApplicationClassMember, String> {}

    @Property(
            domainEvent = MemberNameDomainEvent.class
    )
    @MemberOrder(name="Id", sequence = "2.4")
    public String getMemberName() {
        return super.getMemberName();
    }
    //endregion



}


