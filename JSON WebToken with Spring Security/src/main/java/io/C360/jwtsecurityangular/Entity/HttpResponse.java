package io.C360.jwtsecurityangular.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HttpResponse {

    private int HttpStatusCode;

    private HttpStatus httpStatus;
    private String reason;
    private String message;
}
