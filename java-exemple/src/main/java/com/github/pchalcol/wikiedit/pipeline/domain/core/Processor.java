package com.github.pchalcol.wikiedit.pipeline.domain.core;

import java.util.List;
import java.util.function.Function;

public interface Processor<T extends Event, U extends Event> {
    void addSource(Source<T> source);
    void addSinks(List<Sink<U>> sinks);
    U process(T t, Function<T, U> f) throws ProcessingException;
}
