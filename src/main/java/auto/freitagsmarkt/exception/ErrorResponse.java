package auto.freitagsmarkt.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime localDateTime;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.localDateTime = LocalDateTime.now();
    }
}
