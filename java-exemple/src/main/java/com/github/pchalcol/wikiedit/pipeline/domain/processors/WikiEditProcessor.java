package com.github.pchalcol.wikiedit.pipeline.domain.processors;

import com.github.pchalcol.wikiedit.pipeline.domain.core.ProcessingException;
import com.github.pchalcol.wikiedit.pipeline.domain.core.Processor;
import com.github.pchalcol.wikiedit.pipeline.domain.core.Sink;
import com.github.pchalcol.wikiedit.pipeline.domain.core.Source;
import com.github.pchalcol.wikiedit.pipeline.domain.model.WikiEditSinkEvent;
import com.github.pchalcol.wikiedit.pipeline.domain.model.WikiEditSourceEvent;
import com.github.pchalcol.wikiedit.pipeline.infrastructure.kafka.WikiEditEventRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class WikiEditProcessor implements Processor<WikiEditSourceEvent, WikiEditSinkEvent> {
    private Source<WikiEditSourceEvent> source;
    private List<Sink<WikiEditSinkEvent>> sinks = new ArrayList<>();

    @Override
    public void addSource(Source<WikiEditSourceEvent> source) {
        this.source = source;
    }

    @Override
    public void addSinks(List<Sink<WikiEditSinkEvent>> sinks) {
        this.sinks.addAll(sinks);
    }

    @Override
    public WikiEditSinkEvent process(WikiEditSourceEvent wikiEditSourceEvent, Function<WikiEditSourceEvent, WikiEditSinkEvent> f) throws ProcessingException {
        WikiEditSinkEvent sinkEvent = f.apply(wikiEditSourceEvent);
        sinks.forEach(s -> s.append(sinkEvent));
        return sinkEvent;
    }

}
