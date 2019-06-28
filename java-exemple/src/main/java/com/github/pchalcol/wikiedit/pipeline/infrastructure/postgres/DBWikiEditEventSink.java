package com.github.pchalcol.wikiedit.pipeline.infrastructure.postgres;

import com.github.pchalcol.wikiedit.pipeline.domain.model.repositories.WikiEditEventSink;
import com.github.pchalcol.wikiedit.pipeline.domain.model.WikiEditSinkEvent;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.pchalcol.wikiedit.pipeline.infrastructure.postgres.Config.sqlSessionFactory;

public class DBWikiEditEventSink implements WikiEditEventSink {
    private static Logger logger = LoggerFactory.getLogger(DBWikiEditEventSink.class);
    private SqlSessionFactory sqlSessionFactory = sqlSessionFactory();

    public DBWikiEditEventSink() {
        // create table
        logger.debug("Create table `wikiedit_events`");
        try(SqlSession session = sqlSessionFactory.openSession()) {
            WikiEditSinkEventMapper mapper = session.getMapper(WikiEditSinkEventMapper.class);
            mapper.createWikiEditEventsTable("wikiedit_events");
            session.commit();
            logger.debug("Table `wikiedit_events` created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void append(WikiEditSinkEvent sinkEvent) {
        logger.debug("Insert event in table `wikiedit_events`");
        try(SqlSession session = sqlSessionFactory.openSession()) {
            WikiEditSinkEventMapper mapper = session.getMapper(WikiEditSinkEventMapper.class);
            mapper.save(sinkEvent);
            session.commit();
            logger.debug("Event inserted in table `wikiedit_events`");
            System.err.println("Event inserted in table `wikiedit_events`");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
