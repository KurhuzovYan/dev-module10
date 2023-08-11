package global.goit;

import global.goit.entities.Client;
import global.goit.entities.Planet;
import global.goit.services.ClientCrudService;
import global.goit.services.PlanetCrudService;
import org.flywaydb.core.Flyway;

public class Launcher {
    public static void main(String[] args) {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:postgresql://35.238.176.199:5432/database_yan", "dev12", "dev12thebest")
                .load();

        flyway.migrate();

        new ClientCrudService().createClient(new Client("Liza"));
        new ClientCrudService().deleteClient(2);
        new PlanetCrudService().createPlanet(new Planet("VENUS2", "Asada"));
        new PlanetCrudService().deletePlanet("MARS");
    }
}