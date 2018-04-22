package test.ncube.MemberService.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MemberDto {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @ApiModelProperty(notes = "The database generated member ID")
    private String id;

    @ApiModelProperty(notes = "Member's first name")
    private String firstName;

    @ApiModelProperty(notes = "Member's second name")
    private String secondName;

    @ApiModelProperty(notes = "Member's date of birth")
    private String date;

    @ApiModelProperty(notes = "Member's postal code")
    private int postalCode;

    @Transient
    public Date getDateConverted() throws ParseException {
        return dateFormat.parse(this.date);
    }

    public void setDateConverted(Date date){
        this.date = dateFormat.format(date);
    }

}
