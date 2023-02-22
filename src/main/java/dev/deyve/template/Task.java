package dev.deyve.template;

public abstract class Task {

    private final AuditTrail auditTrail;

    protected Task() {
        this.auditTrail = new AuditTrail();
    }

    protected Task(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }

    public void execute() {
        auditTrail.recordTrail();

        doExecute();
    }

    protected abstract void doExecute();
}
