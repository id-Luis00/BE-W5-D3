package luisQuiroz.BE_W5_D3.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String msg) {
        super(msg);
    }
}
