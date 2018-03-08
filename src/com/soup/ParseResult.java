package com.soup;

public class ParseResult {

    private boolean changed;
    private String string;

    public ParseResult(boolean changed, String string) {
        this.changed = changed;
        this.string = string;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
