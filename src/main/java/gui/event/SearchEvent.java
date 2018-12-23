package gui.event;

import java.util.EventObject;

public class SearchEvent extends EventObject {

    private String search;
    private String document_type;

    public SearchEvent(Object source, String search,String document_type) {
        super(source);
        this.search = search;
        this.document_type = document_type;
    }

    public String getSearch() {
        return search;
    }

    public String getDocument_type() {
        return document_type;
    }
}
