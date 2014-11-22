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
package org.isisaddons.module.security.dom.feature;

import javax.inject.Inject;
import org.apache.isis.applib.DomainObjectContainer;

/**
 * Optional hook so that alternative implementations of {@link org.isisaddons.module.security.dom.feature.ApplicationFeature}.
 *
 * <p>
 *     To use, simply implement the interface and annotate that implementation with {@link org.apache.isis.applib.annotation.DomainService},
 *     for example:
 * </p>
 * <pre>
 *     @DomainService
 *     public class MyApplicationFeatureFactory implements ApplicationFeatureFactory {
 *         public ApplicationFeature newApplicationFeature() {
 *             return container.newTransientInstance(MyApplicationFeature.class);
 *         }
 *
 *         @Inject
 *         DomainObjectContainer container;
 *     }
 * </pre>
 * <p>
 *     where:
 * </p>
 * <pre>
 *     public class MyApplicationFeature extends ApplicationFeature { ... }
 * </pre>
 */
public interface ApplicationFeatureFactory {

    public ApplicationFeature newApplicationFeature();

    public static class Default implements ApplicationFeatureFactory {

        public Default() {
            this(null);
        }
        Default(final DomainObjectContainer container) {
            this.container = container;
        }
        public ApplicationFeature newApplicationFeature() {
            return container.newTransientInstance(ApplicationFeature.class);
        }

        @Inject
        DomainObjectContainer container;

    }

}
