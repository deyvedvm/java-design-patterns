package dev.deyve.template;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskTest {

    @Test
    void executeShouldRunAuditBeforeConcreteStep() {
        var output = capture(new TransferMoneyTask()::execute);

        int auditIndex = output.indexOf("Audit");
        int transferIndex = output.indexOf("Tranfer");

        assertTrue(auditIndex >= 0, "expected Audit in output: " + output);
        assertTrue(transferIndex > auditIndex,
                "audit should come before transfer: " + output);
    }

    @Test
    void differentSubclassesShouldShareTheSkeleton() {
        String transferOutput = capture(new TransferMoneyTask()::execute);
        String reportOutput = capture(new GenerateReportTask()::execute);

        assertTrue(transferOutput.contains("Audit"));
        assertTrue(reportOutput.contains("Audit"));
    }

    private static String capture(Runnable runnable) {
        var buffer = new ByteArrayOutputStream();
        var original = System.out;
        System.setOut(new PrintStream(buffer));
        try {
            runnable.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString();
    }
}
