package kots.terminal.homework;

import java.time.LocalDateTime;

class Fight {

    private final String who;
    private final String with;
    private final LocalDateTime when;

    public Fight(String who, String with, LocalDateTime when) {
        this.who = who;
        this.with = with;
        this.when = when;
    }

    public String getWho() {
        return who;
    }

    public String getWith() {
        return with;
    }
}
