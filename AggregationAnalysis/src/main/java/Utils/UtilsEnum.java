package Utils;

public enum UtilsEnum {
    REPO("AggregationAnalysis\\src\\main\\resources\\csvRepo");

    UtilsEnum(String path) {
        this.path = path;
    }

    private final String path;

    public String getPath() {
        return path;
    }
}
