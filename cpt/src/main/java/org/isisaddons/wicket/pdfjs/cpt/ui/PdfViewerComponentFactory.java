/*
 *  Copyright 2013~2014 Dan Haywood
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
package org.isisaddons.wicket.pdfjs.cpt.ui;

import org.apache.isis.core.metamodel.facets.value.image.ImageValueFacet;
import org.apache.isis.core.metamodel.spec.ObjectSpecification;
import org.apache.isis.viewer.wicket.model.models.ScalarModel;
import org.apache.isis.viewer.wicket.ui.ComponentFactoryAbstract;
import org.apache.isis.viewer.wicket.ui.ComponentType;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

public class PdfViewerComponentFactory extends ComponentFactoryAbstract {

    private static final long serialVersionUID = 1L;

    public PdfViewerComponentFactory() {
        super(ComponentType.SCALAR_NAME_AND_VALUE, PdfViewerPanel.class);
    }

    public ApplicationAdvice appliesTo(IModel<?> model) {
        if(!(model instanceof ScalarModel)) {
            return ApplicationAdvice.DOES_NOT_APPLY;
        } else {
            ScalarModel scalarModel = (ScalarModel)model;
            ObjectSpecification specification = scalarModel.getTypeOfSpecification();
            // TODO mgrigorov Replace ImageValueFacet with PdfJsValueFacet
            return this.appliesIf(specification != null && specification.containsFacet(ImageValueFacet.class));
        }
    }

    public Component createComponent(String id, IModel<?> model) {
        ScalarModel scalarModel = (ScalarModel)model;
        return new PdfViewerPanel(id, scalarModel);
    }
}

