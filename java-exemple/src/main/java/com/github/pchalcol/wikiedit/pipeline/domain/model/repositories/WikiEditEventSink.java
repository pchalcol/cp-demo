package com.github.pchalcol.wikiedit.pipeline.domain.model.repositories;

import com.github.pchalcol.wikiedit.pipeline.domain.core.Sink;
import com.github.pchalcol.wikiedit.pipeline.domain.model.WikiEditSinkEvent;

public interface WikiEditEventSink extends Sink<WikiEditSinkEvent> {}
