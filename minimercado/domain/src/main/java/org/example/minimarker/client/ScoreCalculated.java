package org.example.minimarker.client;

import co.com.sofka.domain.generic.DomainEvent;

public class ScoreCalculated extends DomainEvent {
    private final Double score;

    public ScoreCalculated(Double score) {
        super("sofka.client.scorecalculated");
        this.score = score;
    }

    public Double score() {
        return score;
    }
}
