package org.example.minimarker.client.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.client.values.ClassificationId;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.client.values.Score;

public class CalculateScoreCommand extends Command {

    private final ClientId clientId;
    private final ClassificationId classificationId;
    private final Score score;

    public CalculateScoreCommand (ClientId clientId, ClassificationId classificationId, Score score){
        this.clientId = clientId;
        this.classificationId = classificationId;
        this.score = score;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public ClassificationId getClassificationId() {
        return classificationId;
    }

    public Score getScore() {
        return score;
    }
}
