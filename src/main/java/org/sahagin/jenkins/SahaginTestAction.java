package org.sahagin.jenkins;

import hudson.model.AbstractBuild;
import hudson.tasks.junit.TestAction;

// This action adds link to Sahagin each test report
// to JUnit test report each result page.
public class SahaginTestAction extends TestAction {
    private AbstractBuild<?, ?> build;
    private String qualifiedClassName;
    private String testName;

    public SahaginTestAction(AbstractBuild<?, ?> build, String qualifiedClassName, String testName) {
        this.build = build;
        this.qualifiedClassName = qualifiedClassName;
        this.testName = testName;
    }

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getUrlName() {
        return null;
    }

    public String getBuildUrl() {
        return build.getUrl();
    }

    public String getReportLinkIconFileName() {
        // TODO this is provisional, and is not transparent image
        return "/plugin/sahagin-jenkins-plugin/provisional.png";
    }

    public String getQualifiedClassName() {
        return qualifiedClassName;
    }

    public String getTestName() {
        return testName;
    }

}
