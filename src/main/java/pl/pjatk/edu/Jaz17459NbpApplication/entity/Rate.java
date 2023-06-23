package pl.pjatk.edu.Jaz17459NbpApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rate {
    private String no;
    private String effectiveDate;
    private double mid;
}
