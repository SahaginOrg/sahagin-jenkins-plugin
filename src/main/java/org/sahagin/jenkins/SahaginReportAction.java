package org.sahagin.jenkins;

import java.io.File;
import java.io.IOException;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.FilePath;
import hudson.model.BuildBadgeAction;
import hudson.model.AbstractBuild;
import hudson.model.DirectoryBrowserSupport;

// Since this action implements BuildBadge interface,
// this action adds sahagin badge to build history
// and adds sahagin report link to build page left pain
public class SahaginReportAction implements BuildBadgeAction {
	private static final String buildReportDirName = "sahagin-report";
    private AbstractBuild<?, ?> build;

    public AbstractBuild<?, ?> getBuild() {
        return this.build;
    }

    public SahaginReportAction(AbstractBuild<?, ?> build) {
        this.build = build;
    }

	@Override
	public String getIconFileName() {
		// TODO this is provisional, and is not transparent image
		return "/plugin/sahagin-jenkins-plugin/provisional.png";
	}

	@Override
	public String getDisplayName() {
		return "Sahagin Report";
	}

	@Override
	public String getUrlName() {
		return buildReportDirName;
	}

	public String getBuildUrl() {
		return build.getUrl();
	}

	// associate HTML file and URL
	public DirectoryBrowserSupport doDynamic(StaplerRequest req, StaplerResponse res) throws IOException {
		FilePath buildReportDir = new FilePath(new File(build.getRootDir(), buildReportDirName));
		return new DirectoryBrowserSupport(this, buildReportDir, getDisplayName(), null, false);
    }

}
