package domainapp.modules.exampledom.spi.security.fixture.example.tenanted;

public class RootTenantedEntity extends AbstractTenantedEntityFixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {
        create("Tenanted in /", "/", executionContext);
    }

}