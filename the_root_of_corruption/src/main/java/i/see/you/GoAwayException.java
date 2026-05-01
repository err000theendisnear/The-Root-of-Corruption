package i.see.you;

public class GoAwayException extends NullPointerException {
	public GoAwayException() {
		super();
	}
	public GoAwayException(String s) {
		super(s);
	}
	private transient int extendedMessageState;
    private transient String extendedMessage;
    public synchronized Throwable fillInStackTrace() {
        if (extendedMessageState == 0) {
            extendedMessageState = 1;
        } else if (extendedMessageState == 1) {
            extendedMessage = getExtendedGAEMessage();
            extendedMessageState = 2;
        }
        return super.fillInStackTrace();
    }
	public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            synchronized(this) {
                if (extendedMessageState == 1) {
                    extendedMessage = getExtendedGAEMessage();
                    extendedMessageState = 2;
                }
                return extendedMessage;
            }
        }
        return message;
    }
    private native String getExtendedGAEMessage();
}
