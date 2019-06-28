package com.github.pchalcol.wikiedit.pipeline.domain.model;

import com.github.pchalcol.wikiedit.pipeline.domain.core.Event;
import org.joda.time.DateTime;

public class WikiEditSourceEvent implements Event {
    /**
     * The timestamp of the edit
     */
    private DateTime createdat;

    /**
     * The page that was edited
     */
    private String wikipage;

    /**
     * The source channel the edit came through
     */
    private String channel;

    /**
     * Username of editor
     */
    private String username;

    /**
     * Commit message for edit.
     */
    private String commitmessage;

    /**
     * number of bytes added or removed with this edit.
     */
    private int bytechange;

    /**
     * The URL showing the edit diff.
     */
    private String diffurl;

    /**
     * Is this a new page?
     */
    private boolean isnew;

    /**
     * Is this edit minor?
     */
    private boolean isminor;

    /**
     * Is this an edit by a bot?
     */
    private boolean isbot;

    /**
     * Is this edit unpatrolled?
     */
    private boolean isunpatrolled;

    public static WikiEditSourceEvent of(DateTime createdat,
                                         String wikipage,
                                         String channel,
                                         String username,
                                         String commitmessage,
                                         Integer bytechange,
                                         String diffurl,
                                         Boolean isnew,
                                         Boolean isminor,
                                         Boolean isbot,
                                         Boolean isunpatrolled) {
        return new WikiEditSourceEvent(createdat,
                wikipage,
                channel,
                username,
                commitmessage,
                bytechange,
                diffurl,
                isnew,
                isminor,
                isbot,
                isunpatrolled);
    }

    /**
     * Private constructor
     * @param createdat
     * @param wikipage
     * @param channel
     * @param username
     * @param commitmessage
     * @param bytechange
     * @param diffurl
     * @param isnew
     * @param isminor
     * @param isbot
     * @param isunpatrolled
     */
    private WikiEditSourceEvent(DateTime createdat,
                                String wikipage,
                                String channel,
                                String username,
                                String commitmessage,
                                int bytechange,
                                String diffurl,
                                boolean isnew,
                                boolean isminor,
                                boolean isbot,
                                boolean isunpatrolled) {
        this.createdat = createdat;
        this.wikipage = wikipage;
        this.channel = channel;
        this.username = username;
        this.commitmessage = commitmessage;
        this.bytechange = bytechange;
        this.diffurl = diffurl;
        this.isnew = isnew;
        this.isminor = isminor;
        this.isbot = isbot;
        this.isunpatrolled = isunpatrolled;
    }

    public DateTime getCreatedat() {
        return createdat;
    }

    public String getWikipage() {
        return wikipage;
    }

    public String getChannel() {
        return channel;
    }

    public String getUsername() {
        return username;
    }

    public String getCommitmessage() {
        return commitmessage;
    }

    public int getBytechange() {
        return bytechange;
    }

    public String getDiffurl() {
        return diffurl;
    }

    public boolean isIsnew() {
        return isnew;
    }

    public boolean isIsminor() {
        return isminor;
    }

    public boolean isIsbot() {
        return isbot;
    }

    public boolean isIsunpatrolled() {
        return isunpatrolled;
    }
}
