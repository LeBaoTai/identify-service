package com.lbt.identify.excep;

import com.lbt.identify.enums.ErrorCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class AppException extends RuntimeException{
    ErrorCode errorCode;
}
