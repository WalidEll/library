package gui.event;

import java.util.EventObject;

public class SearchEvent extends EventObject {

    private String search;

    public SearchEvent(Object source, String search) {
        super(source);
        this.search = search;
    }

    public String getSearch() {
        return search;
    }
}
