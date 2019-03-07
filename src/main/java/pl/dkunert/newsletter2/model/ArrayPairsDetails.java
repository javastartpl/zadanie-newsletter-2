package pl.dkunert.newsletter2.model;

import java.util.Set;

public class ArrayPairsDetails {
    private Set<IntTuple> lowestPairs;
    private Set<IntTuple> highestPairs;

    public ArrayPairsDetails(Set<IntTuple> lowestPairs, Set<IntTuple> highestPairs) {
        this.lowestPairs = lowestPairs;
        this.highestPairs = highestPairs;
    }

    public Set<IntTuple> getLowestPairs() {
        return lowestPairs;
    }

    public void setLowestPairs(Set<IntTuple> lowestPairs) {
        this.lowestPairs = lowestPairs;
    }

    public Set<IntTuple> getHighestPairs() {
        return highestPairs;
    }

    public void setHighestPairs(Set<IntTuple> highestPairs) {
        this.highestPairs = highestPairs;
    }

    @Override
    public String toString() {
        return "ArrayPairsDetails{" +
                "lowestPairs=" + lowestPairs +
                ", highestPairs=" + highestPairs +
                '}';
    }
}
