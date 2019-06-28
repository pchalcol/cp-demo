package com.github.pchalcol.wikiedit.standalone;

import org.joda.time.DateTime;

import java.util.Date;

public class WikiEditEventFactory {
    public static WikiEditEvent of(String username,
                                   String channel,
                                   String commitMessage,
                                   String wikiPage,
                                   String diffurl,
                                   Date createdAt) {

        DateTime createdAtDt = new DateTime(createdAt);
        return new WikiEditEvent(username,
                channel,
                commitMessage,
                wikiPage,
                diffurl,
                createdAtDt);
    }
}
