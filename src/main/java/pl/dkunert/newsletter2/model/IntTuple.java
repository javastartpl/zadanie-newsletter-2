package pl.dkunert.newsletter2.model;

import java.util.Objects;

public class IntTuple {
    private int first;
    private int second;

    public IntTuple(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getSum() {
        return second + first;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntTuple tuple = (IntTuple) o;
        return first == tuple.first &&
                second == tuple.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "IntTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
