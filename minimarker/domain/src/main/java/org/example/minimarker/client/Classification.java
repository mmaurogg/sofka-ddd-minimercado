package org.example.minimarker.client;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.client.values.Category;
import org.example.minimarker.client.values.ClassificationId;
import org.example.minimarker.client.values.Score;

import java.util.Objects;

public class Classification extends Entity<ClassificationId> {
    private Score score;
    private Category category;

    public Classification(ClassificationId entityId) throws IllegalAccessException {
        super(entityId);
        this.score = new Score(0.0);
    }
    private void updateCategory(){
        this.category = new Category(categorize());
    }

    public void updateScore(Score score) {
        this.score = new Score(score.value());
        updateCategory();
    }

    private String categorize () {
        if(this.score.value() < 10 ){
            return "nuevo";
        } else if(this.score.value() < 20 ){
            return "frecuente";
        } else  {
            return "premium";
        }
    }

    public Score score() {
        return score;
    }

    public Category category() {
        return category;
    }
}
