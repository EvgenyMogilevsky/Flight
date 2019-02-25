package main.java.com.flights.example.domain.model;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CashInMemory implements Cashe {
    private Map<String, String> cash = new HashMap<>();
    @Override
    public boolean put(String key, String value) {
        cash.put(key, value);
        return true;
    }

    @Override
    public boolean getValue(String s) {
        return cash.containsKey(s);
    }
}
