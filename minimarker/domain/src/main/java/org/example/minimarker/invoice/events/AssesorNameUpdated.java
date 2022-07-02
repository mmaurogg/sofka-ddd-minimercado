package org.example.minimarker.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.invoice.values.AssessorId;
import org.example.minimarker.invoice.values.NameAssessor;

public class AssesorNameUpdated extends DomainEvent {
    private final AssessorId assessorId;
    private final NameAssessor name;

    public AssesorNameUpdated(AssessorId assessorId, NameAssessor name) {
        super("sofka.Invoice.assesornameupdated");
        this.assessorId = assessorId;
        this.name = name;
    }

    public AssessorId assessorId() {
        return assessorId;
    }

    public NameAssessor name() {
        return name;
    }
}
