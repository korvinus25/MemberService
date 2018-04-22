package test.ncube.MemberService.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Member implements Serializable {

    @Id
    private String id;

    private String firstName;

    private String secondName;

    private Date dateOfBirth;

    private int postalCode;

}


