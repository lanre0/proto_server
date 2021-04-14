package com.task.betpawa_server.service;


import com.task.betpawa_server.entity.Currency;
import com.task.betpawa_server.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyServicesImpl implements CurrencyServices {

    @Autowired
    CurrencyRepository currencyRepository;
    @Override
    public Optional<Currency> findByCurrency_id(Long currency_id) {
        return currencyRepository.findById(currency_id);
    }

    @Override
    public Optional<Currency> findByCurrency_name(String currency_name) {
        return currencyRepository.findByCurrencyName(currency_name);
    }
}
