package cybersoft.javabackend.java18.gira.common.model;

import lombok.Builder;

import java.util.List;

@Builder
public class ResponseDTO {
    private Object content;
    private boolean hasErrors;
    private List<String> errors;
    private String timestamp;
    private int status;
}
