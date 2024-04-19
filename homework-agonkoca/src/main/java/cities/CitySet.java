package cities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CitySet implements Comparable<CitySet> {
    public static final Comparator<CitySet> COMPARATOR = new CitySetComparator();
    @EqualsAndHashCode.Include
    private String code;
    private String name;
    private int population;
    private int area_km2;
    private Budget budget;
    @ToString.Exclude
    private Set<Identifications> identification;

    @Override
    public int compareTo(CitySet o) {
        return Objects.compare(this, o, COMPARATOR);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class Identifications {
        @EqualsAndHashCode.Include
        private final int postal_code;
        private final String area_code;
        private final String vehicle_registration;
    }

    public enum Budget {
        @JsonProperty("Very high") VERY_HIGH,
        @JsonProperty("High") HIGH,
        @JsonProperty("Medium") MEDIUM,
        @JsonProperty("Low") LOW
    }

    public static class CitySetComparator implements Comparator<CitySet> {

        @Override
        public int compare(CitySet o1, CitySet o2) {
            if (!Objects.equals(o1.code, o2.code)) {
                return Objects.compare(o1.code, o2.code, Comparator.reverseOrder());
            }
            if (o1.population != o2.population) {
                return Objects.compare(o1.population, o2.population, Comparator.naturalOrder());
            }
            return Objects.compare(o1.name, o2.name, Comparator.reverseOrder());
        }
    }
}
