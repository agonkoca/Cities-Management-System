package cities;

import java.io.IOException;

public class CityTest {
    public static void main(String[] args) throws IOException {
        final var repo = new CityRepository();
        System.out.println(repo);
        System.out.println("------------------------");
        System.out.println(repo.getMaximumPopulation());
        System.out.println("------------------------");
        System.out.println(repo.getCityNames());
        System.out.println("------------------------");
        System.out.println(repo.getCitiesOrderByPopulationDesc());
        System.out.println("------------------------");
        System.out.println(repo.getCountOfCitiesByBudgets());
        System.out.println("------------------------");
        System.out.println(repo.getCitiesByBudgets());
        System.out.println("------------------------");
        System.out.println(repo.getCitiesByBudgetsAndCodes());
    }
}
