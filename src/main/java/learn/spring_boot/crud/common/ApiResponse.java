package learn.spring_boot.crud.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse<T> {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private T data;
}
