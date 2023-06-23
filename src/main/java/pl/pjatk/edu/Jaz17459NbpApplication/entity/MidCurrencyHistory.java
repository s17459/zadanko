package pl.pjatk.edu.Jaz17459NbpApplication.entity;


import pl.pjatk.edu.Jaz17459NbpApplication.config.RestTemplateConfig;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class MidCurrencyHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Id number", required = true, dataType = "Long")
    private Long id;
    @ApiModelProperty(notes = "Currency", required = true, dataType = "String")
    private String currency;
    @ApiModelProperty(notes = "Average prise from dates", required = true, dataType = "Double")
    private double average;
    @ApiModelProperty(notes = "Date From: format 2020-01-01", required = true, dataType = "LocalDate")
    private LocalDate dateFrom = RestTemplateConfig.getDate();
    @ApiModelProperty(notes = "Date To: format 2020-01-01", required = true, dataType = "LocalDate")
    private LocalDate dateTo = RestTemplateConfig.getDate();
    private LocalDate searchTime;

    public MidCurrencyHistory(String currency, double average, LocalDate dateFrom, LocalDate dateTo) {
        this.currency = currency;
        this.average = average;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
