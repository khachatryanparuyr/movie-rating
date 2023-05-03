package aca.demo.movierating.endpoint;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class ErrorResponse {
    private final int errorCode;
    private final String description;
    private final String field;

}
