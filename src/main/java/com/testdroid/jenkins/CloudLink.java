package com.testdroid.jenkins;

import hudson.model.AbstractBuild;
import hudson.model.BuildBadgeAction;

/**
 * @author Michał Szpruta <michal.szpruta@bitbar.com>
 */
public class CloudLink implements BuildBadgeAction {

    public final AbstractBuild<?, ?> owner;

    private String cloudLink;

    public CloudLink(AbstractBuild<?, ?> owner, String cloudLink) {
        this.owner = owner;
        this.cloudLink = cloudLink;
    }

    public boolean hasLink() {
        return cloudLink != null;
    }

    @Override
    public String getIconFileName() {
        return "cloud.gif";
    }

    @Override
    public String getDisplayName() {
        return "See detailed results in Testdroid Cloud";
    }

    @Override
    public String getUrlName() {
        return cloudLink;
    }
}
