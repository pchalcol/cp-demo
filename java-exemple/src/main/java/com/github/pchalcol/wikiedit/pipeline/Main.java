package com.github.pchalcol.wikiedit.pipeline;

import com.github.pchalcol.wikiedit.pipeline.domain.core.Topology;
import com.github.pchalcol.wikiedit.pipeline.domain.model.repositories.WikiEditSource;
import com.github.pchalcol.wikiedit.pipeline.domain.core.Sink;
import com.github.pchalcol.wikiedit.pipeline.domain.processors.WikiEditProcessor;
import com.github.pchalcol.wikiedit.pipeline.infrastructure.es.ESWikiEditEventSink;
import com.github.pchalcol.wikiedit.pipeline.infrastructure.kafka.WikiEditKConsumer;
import com.github.pchalcol.wikiedit.pipeline.infrastructure.kafka.KafkaWikiEventSink;
import com.github.pchalcol.wikiedit.pipeline.infrastructure.postgres.DBWikiEditEventSink;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().topology().start();
    }

    private Topology topology() {
        final WikiEditSource source = new WikiEditKConsumer("source-1", true);

        List<Sink> sinks = new ArrayList<>();
        sinks.add(new KafkaWikiEventSink("transformed-sink-1", "transformed-wikiedit-sink")); // kafka sink
        sinks.add(new DBWikiEditEventSink()); // postgres sink
        sinks.add(new ESWikiEditEventSink()); // es sink

        return new Topology()
                .addSource(source)
                .addProcessors(Collections.singletonList(new WikiEditProcessor()))
                .addSinks(sinks)
                .build();
    }
}
