package learn.spring_boot.crud.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError<T> {
    private LocalDateTime timestamp;
    private int status;
    private T message;

    public ApiError(T message) {
        this.timestamp = LocalDateTime.now();
        this.status = 400;
        this.message = message;
    }
}
