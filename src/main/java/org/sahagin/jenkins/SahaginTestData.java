package org.sahagin.jenkins;

import java.util.Collections;
import java.util.List;

import hudson.model.AbstractBuild;
import hudson.tasks.junit.TestAction;
import hudson.tasks.junit.TestObject;
import hudson.tasks.junit.TestResultAction.Data;
import hudson.tasks.junit.CaseResult;

@SuppressWarnings("deprecation")
public class SahaginTestData extends Data {
    private AbstractBuild<?, ?> build;

    public SahaginTestData(AbstractBuild<?, ?> build) {
        this.build = build;
    }

    @Override
    public List<? extends TestAction> getTestAction(TestObject testObject) {
        if (!(testObject instanceof CaseResult)) {
            // Add information only to test case result.
            // Not add to package result or class result.
            return Collections.emptyList();
        }

        CaseResult caseResult = (CaseResult) testObject;
        String qualifiedClassName = caseResult.getClassName();
        String testName = caseResult.getName();
        return Collections.singletonList(new SahaginTestAction(build, qualifiedClassName, testName));
    }

}
