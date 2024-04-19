package cities;

import base.Queries;
import base.Repository;

import java.io.IOException;
import java.util.*;

public class CityRepository extends Repository<CitySet> implements Queries<CitySet, CitySet.Identifications, CitySet.Budget> {
    /**
     * A constructor for initializing the repository.
     *
     * @throws IOException if an I/O error happens
     */
    public CityRepository() throws IOException {
        super(CitySet.class);
    }

    @Override
    public long getMaximumPopulation() {
        int max = getAll().get(0).getPopulation();
        for (int i = 1; i < getAll().size(); i++) {
            if (getAll().get(i).getPopulation() > max) {
                max = getAll().get(i).getPopulation();
            }

        }
        return max;
    }

    @Override
    public Set<String> getCityNames() {
        Set<String> names = new HashSet<>();
        for (CitySet citySet : getAll()) {
            names.add(citySet.getName());
        }
        return names;
    }

    @Override
    public List<CitySet> getCitiesOrderByPopulationDesc() {
        List<CitySet> citySets = new ArrayList<>(getAll());
        citySets.sort(new Comparator<CitySet>() {
            @Override
            public int compare(CitySet o1, CitySet o2) {
                return -Long.compare(o1.getPopulation(), o2.getPopulation());
            }
        });
        return citySets;
    }

    @Override
    public Map<CitySet.Budget, Long> getCountOfCitiesByBudgets() {
        Map<CitySet.Budget, Long> result = new EnumMap<>(CitySet.Budget.class);
        for (CitySet citySet : getAll()) {
            result.put(
                    citySet.getBudget(),
                    result.getOrDefault(citySet.getBudget(), 0L) + 1
            );

        }
        return result;
    }

    @Override
    public Map<CitySet.Budget, Set<CitySet>> getCitiesByBudgets() {
        Map<CitySet.Budget, Set<CitySet>> result = new EnumMap<>(CitySet.Budget.class);
        for (CitySet.Budget budget : CitySet.Budget.values()) {
            result.put(budget, new HashSet<>());
        }
        for (CitySet citySet : getAll()) {
            result.get(citySet.getBudget()).add(citySet);
        }
        return result;
    }

    @Override
    public Map<CitySet.Budget, Map<String, CitySet>> getCitiesByBudgetsAndCodes() {
        Map<CitySet.Budget, Map<String, CitySet>> result = new EnumMap<>(CitySet.Budget.class);

        for (CitySet citySet : getAll()) {
            if (!result.containsKey(citySet.getBudget())) {
                result.put(citySet.getBudget(), new TreeMap<>());
            }
            result.get(citySet.getBudget())
                    .put(citySet.getCode(), citySet);
        }
        return result;
    }
}
