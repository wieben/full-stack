package fullstack.webapp;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class ResteasyServicesApplication extends Application
{
    @Override
    public Set<Object> getSingletons()
    {
        return Set.of(new EndpointForForm());
    }
}
