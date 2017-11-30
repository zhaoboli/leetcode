package tw;

public class RouteResult {

    private int value;
    private String message;

    public RouteResult(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return this.value;
    }

    public String getMessage() {
        return this.message;
    }

    public void setValue(int val) {
        this.value = val;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }
}
