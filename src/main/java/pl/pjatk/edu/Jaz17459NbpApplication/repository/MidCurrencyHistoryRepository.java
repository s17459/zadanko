package pl.pjatk.edu.Jaz17459NbpApplication.repository;

import pl.pjatk.edu.Jaz17459NbpApplication.entity.MidCurrencyHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MidCurrencyHistoryRepository extends JpaRepository<MidCurrencyHistory, Long> {
}
