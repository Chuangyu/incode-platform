#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.incode.domainapp.example.dom.demo.dom.invoicewithatpath;

import java.util.List;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.SemanticsOf;

/**
 * as used by DocFragment
 */
@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "exampleDemo.DemoInvoiceMenu"
)
@DomainServiceLayout(
        named = "Dummy",
        menuOrder = "20.2"
)
public class DemoInvoiceWithAtPathMenu {


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "1")
    public List<DemoInvoiceWithAtPath> listAllDemoInvoices() {
        return demoInvoiceWithAtPathRepository.listAll();
    }


    @javax.inject.Inject
    DemoInvoiceWithAtPathRepository demoInvoiceWithAtPathRepository;

}
