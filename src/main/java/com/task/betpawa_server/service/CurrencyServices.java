package com.task.betpawa_server.service;

import com.task.betpawa_server.entity.Currency;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CurrencyServices {
    public Optional<Currency> findByCurrency_id(Long currency_id);

    public Optional<Currency> findByCurrency_name(String currency_name);
}
