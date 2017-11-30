package tw;

public class TrainMapException extends Exception{
    String errorMsg;

    public TrainMapException() {
        this.errorMsg = "No error";
    }
    public TrainMapException(String msg) {
        this.errorMsg = msg;
    }

    public String errorMsg() {
        return this.errorMsg;
    }
}
