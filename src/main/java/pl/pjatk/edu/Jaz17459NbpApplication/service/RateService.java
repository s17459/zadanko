package pl.pjatk.edu.Jaz17459NbpApplication.service;

import pl.pjatk.edu.Jaz17459NbpApplication.entity.MidCurrencyHistory;
import pl.pjatk.edu.Jaz17459NbpApplication.entity.Root;
import pl.pjatk.edu.Jaz17459NbpApplication.repository.MidCurrencyHistoryRepository;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class RateService {

    private final RestTemplate restTemplate;
    public final MidCurrencyHistoryRepository midCurrencyHistory;


    public MidCurrencyHistory getPrice(String currency, LocalDate dateFrom, LocalDate dateTo) {
        var root = restTemplate.getForObject
                ("http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + dateFrom + "/" + dateTo, Root.class);
        Double average = 0D;
        assert root != null;
        var dataBase = new MidCurrencyHistory(root.getCurrency(), average, dateFrom, dateTo);
        midCurrencyHistory.save(dataBase);
        return dataBase;
    }
}
