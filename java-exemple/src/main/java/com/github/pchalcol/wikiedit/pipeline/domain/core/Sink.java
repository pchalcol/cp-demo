package com.github.pchalcol.wikiedit.pipeline.domain.core;

public interface Sink<T> {
    void append(T e);
}
