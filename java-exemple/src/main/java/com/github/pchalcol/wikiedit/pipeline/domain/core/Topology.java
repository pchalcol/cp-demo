package com.github.pchalcol.wikiedit.pipeline.domain.core;

import java.util.ArrayList;
import java.util.List;

public class Topology {
    private Source source;
    private final List<Processor> processors = new ArrayList<>();
    private final List<Sink> sinks = new ArrayList<>();

    public Topology addSource(Source source) {
        this.source = source;
        return this;
    }

    public Topology addProcessors(List<Processor> processors) {
        this.processors.addAll(processors);
        return this;
    }

    public Topology addSinks(List<Sink> sinks) {
        this.sinks.addAll(sinks);
        return this;
    }

    public Topology build() {
        if(source == null) throw new TopologyException();
        if (this.processors.isEmpty()) throw new TopologyException();
        if (this.sinks.isEmpty()) throw new TopologyException();

        this.source.registerProcessors(processors);
        processors.forEach(p -> {
            p.addSource(this.source);
            p.addSinks(sinks);
        });

        return this;
    }

    public void start() { // TODO gerer plusieurs sources, chacune dans un thread
        source.read();
    }
}
