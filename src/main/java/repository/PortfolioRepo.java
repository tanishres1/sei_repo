package repository;

import model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepo  extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findClientId(Long ClientId);

}
