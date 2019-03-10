package program.views;

public abstract class View {

    protected static String XML_FILE;
    private static String CSS_FILE = "/program/resources/styles/mainStyle.css";
    private static final String LABEL = "FoodGet";
    private static final int WIDTH = 720;
    private static final int HEIGHT = 580;

    public static String getXmlFile() {
        return XML_FILE;
    }

    public static String getCssFile() {
        return CSS_FILE;
    }

    public static String getLABEL() {
        return LABEL;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
}
