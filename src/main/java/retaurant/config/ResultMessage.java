package retaurant.config;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessage<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success;
    private String message;
    private String code;
    @Builder.Default
    private long timestamp = System.currentTimeMillis();
    @ToString.Exclude
    private T result;

    public static <T> ResultMessage<T> success(T data, String message) {
        return ResultMessage.<T>builder()
                .success(true).message(message)
                .code("0")
                .result(data)
                .build();
    }

    public static ResultMessage<Void> success() {
        return ResultMessage.<Void>builder()
                .success(true)
                .code("0")
                .build();
    }

    public static <T> ResultMessage<T> error(String code, String message, T detail) {
        return ResultMessage.<T>builder()
                .success(false)
                .code(code)
                .message(message)
                .result(detail)
                .build();
    }

    public static <T> ResultMessage<T> error(String code, String message) {
        return ResultMessage.<T>builder()
                .success(false)
                .code(code)
                .message(message)
                .build();
    }
}
