package otus.spring.albot.lesson14.domain;

public enum Language {
    EN("EN","en"),
    RU("RU","ru_RU");

    private String display;
    private String key;

    Language(String display, String key) {
        this.display = display;
        this.key = key;
    }

    public String getDisplay() {
        return display;
    }

    public String getKey() {
        return key;
    }
}
