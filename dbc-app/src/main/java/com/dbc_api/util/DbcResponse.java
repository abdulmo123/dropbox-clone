package com.dbc_api.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DbcResponse<T> {
    private String message;
    private T data;
    private int statusCode;
}
