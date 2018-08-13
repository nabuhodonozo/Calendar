package pl.solsoft.calendar.views;

public enum ViewType {
    WEEK("week"),
    MONTH("month");

    private String viewType;

    ViewType(String string) {
        this.viewType = string;
    }

    public String getViewType() {
        return this.viewType;
    }
}
