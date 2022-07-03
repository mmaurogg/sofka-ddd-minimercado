package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Score implements ValueObject<Double> {

    private final Double score;

    public Score(Double score) {
        this.score = Objects.requireNonNull(score);
    }
    @Override
    public Double value() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Score that = (Score)  obj;
        return Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
