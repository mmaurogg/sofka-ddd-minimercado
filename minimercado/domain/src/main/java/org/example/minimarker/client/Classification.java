package org.example.minimarker.client;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.client.values.Category;
import org.example.minimarker.client.values.ClassificationId;
import org.example.minimarker.client.values.Score;

import java.util.Objects;

public class Classification extends Entity<ClassificationId> {
    private Score score;
    private Category category;

    public Classification(ClassificationId entityId) {
        super(entityId);
        this.score = new Score();
    }

    public void updateCategory(){
        this.category = new Category(categorize());
    }

    public void updateScore(Score score) throws IllegalAccessException {
        this.score = Objects.requireNonNull(score);
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
