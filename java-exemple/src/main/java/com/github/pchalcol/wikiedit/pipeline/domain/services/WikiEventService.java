package com.github.pchalcol.wikiedit.pipeline.domain.services;

import com.github.pchalcol.wikiedit.pipeline.domain.model.ModelException;
import com.github.pchalcol.wikiedit.pipeline.domain.model.WikiEditSinkEvent;
import com.github.pchalcol.wikiedit.pipeline.domain.model.WikiEditSourceEvent;

public class WikiEventService {
    /*public WikiEditEventRecord transform(WikiEditSourceEvent source) {
        return WikiEditEventFactory.of(source.getUsername(),
                source.getChannel(),
                source.getCommitmessage(),
                source.getWikipage(),
                source.getDiffurl(),
                source.getCreatedat().toDate());
    }*/

    // TODO supprimer la dependance sur infrastructure
    // FIXME remove cast
    public Object transform(Object o) {
        if (null == o) throw new ModelException();
        WikiEditSourceEvent source = (WikiEditSourceEvent) o;
        return WikiEditSinkEvent.of(source.getUsername(),
                source.getChannel(),
                source.getCommitmessage(),
                source.getWikipage(),
                source.getDiffurl(),
                source.getCreatedat().toDate());
    }
}