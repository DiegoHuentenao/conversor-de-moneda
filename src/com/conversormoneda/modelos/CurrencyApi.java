package com.conversormoneda.modelos;

import java.util.Map;

public record CurrencyApi(String base_code, Map conversion_rates) {
}
