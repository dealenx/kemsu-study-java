package dealenx.geometry.exceptions;

public class MyException extends Exception {

    private int errorCode;

    // переопределяем конструктор
    public MyException(String message) {
        this(0, message);
    }

    // Создаем свой конструктор
    public MyException(int l_errorCode, String l_message) {
        super(l_message);
        errorCode = l_errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
