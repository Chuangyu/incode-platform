package org.incode.domainapp.example.dom.lib.stringinterpolator.dom.demo;

import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "exampleLibStringInterpolator.ToDoItems"
)
@DomainServiceLayout(
        menuOrder = "10",
        named = "StringInterpolator ToDos"
)
public class StringInterpolatorDemoToDoItems {


    //region > newToDo (action)

    @MemberOrder(sequence = "40")
    public StringInterpolatorDemoToDoItem newToDo(
            @ParameterLayout(named = "Description") @Parameter(regexPattern = "\\w[@&:\\-\\,\\.\\+ \\w]*")
            final String description,
            @ParameterLayout(named = "Documentation page")
            final String documentationPage) {

        final StringInterpolatorDemoToDoItem toDoItem = container.newTransientInstance(StringInterpolatorDemoToDoItem.class);
        toDoItem.setDescription(description);
        toDoItem.setDocumentationPage(documentationPage);

        container.persist(toDoItem);
        container.flush();

        return toDoItem;
    }
    //endregion

    //region > allToDos (action)


    @Action(
            semantics = SemanticsOf.SAFE
    )
    @MemberOrder(sequence = "50")
    public List<StringInterpolatorDemoToDoItem> allToDos() {
        return container.allInstances(StringInterpolatorDemoToDoItem.class);
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    private DomainObjectContainer container;

    //endregion

}
