package com.github.pchalcol.wikiedit.pipeline.domain.core;

import java.util.Collection;
import java.util.List;

public interface Source<S> extends Runnable {
    Collection<S> read();
    void registerProcessors(List<Processor> processors);
}
