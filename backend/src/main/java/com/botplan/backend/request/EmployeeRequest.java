package com.botplan.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    @NotNull
    private String name;

    @NotNull
    private String picture;

    @NotNull
    private String stack;

    @NotNull
    private String technologies;

    @NotNull
    private String seniority;

    @NotNull
    private boolean admin;

    @NotNull
    private String type;

    @NotNull
    private boolean isWorking;

    @NotNull
    private String reasonWhyNotWorking;

}
