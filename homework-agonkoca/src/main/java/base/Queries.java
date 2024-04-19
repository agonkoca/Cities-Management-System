package base;

import cities.CitySet;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Defines queries for your {@link Repository} implementation.
 *
 * @param <T> the type of your entity (first class)
 * @param <U> the type of your nested class (second class)
 * @param <V> the type of your enum class
 */

public interface Queries<T, U, V extends Enum<V>> {
    /**
     * Returns the value of the maximum population.
     *
     * @return the maximum population
     */
    long getMaximumPopulation();

    /**
     * Returns the name of each city.
     *
     * @return the set of names
     */
    Set<String> getCityNames();

    /**
     * Returns a new list of cities ordered by:
     *
     * <ol>
     *     <li>their populations in descending order</li>
     * </ol>
     *
     * @return the sorted list of cities
     */
    List<CitySet> getCitiesOrderByPopulationDesc();

    /**
     * Returns a dictionary which maps each budget to the count of its cities.
     *
     * @return the dictionary
     */
    Map<CitySet.Budget, Long> getCountOfCitiesByBudgets();


    /**
     * Returns a dictionary which maps each budget to its cities.
     *
     * @return the dictionary
     */
    Map<CitySet.Budget, Set<CitySet>> getCitiesByBudgets();

    /**
     * Returns a dictionary which maps each budget to the corresponding city codes, then each city code to the corresponding city.
     *
     * @return the dictionary
     */
    Map<CitySet.Budget, Map<String, CitySet>> getCitiesByBudgetsAndCodes();
}
