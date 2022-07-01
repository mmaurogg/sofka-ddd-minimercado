package org.example.minimarker.invoice;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.invoice.values.AssessorId;
import org.example.minimarker.invoice.values.NameAssessor;
import org.example.minimarker.product.values.Name;

import java.util.Objects;

public class Assessor extends Entity<AssessorId> {

    private NameAssessor name;

    public Assessor(AssessorId entityId, NameAssessor name) {
        super(entityId);
        this.name = name;
    }

    public void updateName(NameAssessor name){
        this.name = Objects.requireNonNull(name);
    }

    public NameAssessor name() {
        return name;
    }
}
