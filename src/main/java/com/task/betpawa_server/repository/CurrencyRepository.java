package com.task.betpawa_server.repository;

import com.task.betpawa_server.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {
    Optional<Currency>  findByCurrencyName(String currency_name);
}
