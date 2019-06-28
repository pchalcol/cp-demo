package com.github.pchalcol.wikiedit.pipeline.domain.model;

import com.github.pchalcol.wikiedit.pipeline.domain.core.Event;

import java.util.Date;

public class WikiEditSinkEvent implements Event {
    private final String username;
    private final String channel;
    private final String commitMessage;
    private final String wikiPage;
    private final String diffurl;
    private final Date createdAt;

    public static WikiEditSinkEvent of(String username,
                                       String channel,
                                       String commitMessage,
                                       String wikiPage,
                                       String diffurl,
                                       Date createdAt) {
        return new WikiEditSinkEvent(username,
                channel,
                commitMessage,
                wikiPage,
                diffurl,
                createdAt);
    }


    private WikiEditSinkEvent(String username,
                              String channel,
                              String commitMessage,
                              String wikiPage,
                              String diffurl,
                              Date createdAt) {
        this.username = username;
        this.channel = channel;
        this.commitMessage = commitMessage;
        this.wikiPage = wikiPage;
        this.diffurl = diffurl;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public String getChannel() {
        return channel;
    }

    public String getCommitMessage() {
        return commitMessage;
    }

    public String getWikiPage() {
        return wikiPage;
    }

    public String getDiffurl() {
        return diffurl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
