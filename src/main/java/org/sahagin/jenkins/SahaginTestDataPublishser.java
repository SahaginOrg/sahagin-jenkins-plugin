package org.sahagin.jenkins;

import java.io.IOException;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.model.Descriptor;
import hudson.tasks.junit.TestDataPublisher;
import hudson.tasks.junit.TestResult;
import hudson.tasks.junit.TestResultAction.Data;

public class SahaginTestDataPublishser extends TestDataPublisher {

    @DataBoundConstructor
    public SahaginTestDataPublishser() {}

    @Override
    public Data getTestData(AbstractBuild<?, ?> build, Launcher launcher,
            BuildListener listener, TestResult testResult)
                    throws IOException, InterruptedException {
        return new SahaginTestData(build);
    }

    // configuration of additional test report features for JUnit test result report
    @Extension
    public static class SahaginTestDataPublishserDescriptor extends Descriptor<TestDataPublisher> {

        @Override
        public String getDisplayName() {
            return "Add Sahagin test report link to each test result";
        }
    }

}
