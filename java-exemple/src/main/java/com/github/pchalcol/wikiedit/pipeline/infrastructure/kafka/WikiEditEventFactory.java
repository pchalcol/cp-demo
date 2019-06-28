package com.github.pchalcol.wikiedit.pipeline.infrastructure.kafka;

import org.joda.time.DateTime;

import java.util.Date;

public class WikiEditEventFactory {
    public static WikiEditEventRecord of(String username,
                                         String channel,
                                         String commitMessage,
                                         String wikiPage,
                                         String diffurl,
                                         Date createdAt) {

        DateTime createdAtDt = new DateTime(createdAt);
        return new WikiEditEventRecord(username,
                channel,
                commitMessage,
                wikiPage,
                diffurl,
                createdAtDt);
    }
}
