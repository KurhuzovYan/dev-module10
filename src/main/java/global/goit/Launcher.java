package global.goit;

import global.goit.entities.Client;
import global.goit.entities.Planet;
import global.goit.services.ClientCrudService;
import global.goit.services.PlanetCrudService;
import global.goit.utils.HibernateUtils;
import global.goit.utils.MigrationUtils;

public class Launcher {
    public static void main(String[] args) {

        MigrationUtils.checkMigration();

        ClientCrudService clientService = new ClientCrudService();

        clientService.createClient(new Client("Liza"));
        System.out.println(clientService.readClient(4L));
        clientService.updateClient(5, "Viktor");
        clientService.deleteClient(2);
        clientService.getAllClients().forEach(System.out::println);

        PlanetCrudService planetService = new PlanetCrudService();

        planetService.createPlanet(new Planet("VENUS2", "ASADA"));
        System.out.println(planetService.readPlanet("JUP7"));
        planetService.updatePlanet("VENUS2", "ASAP6");
        planetService.deletePlanet("MARS");
        planetService.getAllPlanets().forEach(System.out::println);

        HibernateUtils.getInstance().close();
    }
}