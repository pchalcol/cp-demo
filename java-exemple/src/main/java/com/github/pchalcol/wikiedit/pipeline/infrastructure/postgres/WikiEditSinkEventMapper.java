package com.github.pchalcol.wikiedit.pipeline.infrastructure.postgres;

import com.github.pchalcol.wikiedit.pipeline.domain.model.WikiEditSinkEvent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface WikiEditSinkEventMapper {
    @Insert("insert into wikiedit_events(" +
            "username," +
            "channel," +
            "commit_message," +
            "wiki_age," +
            "diffurl," +
            "created_at) values (" +
            "#{username}, #{channel}, #{commitMessage}, #{wikiPage}, #{diffurl}, #{createdAt})")
    Integer save(WikiEditSinkEvent event);

    @Update("CREATE TABLE IF NOT EXISTS ${_parameter} (" +
            "username text," +
            "channel text," +
            "commit_message text," +
            "wiki_age text," +
            "diffurl text," +
            "created_at timestamp)")
    void createWikiEditEventsTable(String name);
}
