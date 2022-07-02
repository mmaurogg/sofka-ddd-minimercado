package org.example.minimarker.client.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.ClassificationId;
import org.example.minimarker.client.values.Score;

public class ScoreCalculated extends DomainEvent {
    private final ClassificationId classificationId;
    private final Score score;

    public ScoreCalculated(ClassificationId classificationId, Score score) {
        super("sofka.client.scorecalculated");
        this.classificationId = classificationId;
        this.score = score;
    }


    public ClassificationId classificationId() {
        return classificationId;
    }

    public Score score() {
        return score;
    }

}
