package pl.pjatk.edu.Jaz17459NbpApplication.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Root {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;
}
