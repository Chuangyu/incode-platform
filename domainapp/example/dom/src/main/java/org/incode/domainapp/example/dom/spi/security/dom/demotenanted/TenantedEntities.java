package org.incode.domainapp.example.dom.spi.security.dom.demotenanted;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.isisaddons.module.security.dom.tenancy.ApplicationTenancy;
import org.incode.domainapp.example.dom.spi.security.dom.demonontenanted.NonTenantedEntity;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "exampleSpiSecurity.TenantedEntities",
        repositoryFor = TenantedEntity.class
)
@DomainServiceLayout(
        menuOrder = "20",
        named = "Security Tenanted"
)
public class TenantedEntities {

    @Programmatic
    public String getId() {
        return "TenantedEntities";
    }

    public String iconName() {
        return "TenantedEntity";
    }



    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "1")
    public List<TenantedEntity> listAll() {
        return container.allInstances(TenantedEntity.class);
    }



    @MemberOrder(sequence = "2")
    public TenantedEntity create(
            @Parameter(maxLength = NonTenantedEntity.MAX_LENGTH_NAME)
            @ParameterLayout(named="Name")
            final String name,
            final ApplicationTenancy tenancy) {
        final TenantedEntity obj = new TenantedEntity(name, null, tenancy.getPath());
        container.persistIfNotAlready(obj);
        return obj;
    }


    @javax.inject.Inject 
    DomainObjectContainer container;

}
