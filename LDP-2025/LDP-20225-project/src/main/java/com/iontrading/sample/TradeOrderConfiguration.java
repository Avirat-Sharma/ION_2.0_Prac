package com.iontrading.sample;

import com.iontrading.isf.configuration.api.annotation.ConfigurationGroup;
import com.iontrading.isf.configuration.api.annotation.ConfigurationProperty;

import java.math.BigDecimal;

@ConfigurationGroup(namespace = "order.")
public interface TradeOrderConfiguration {
    @ConfigurationProperty(name="currency",mandatory = true)
    String getOrderCurrency();
    @ConfigurationProperty(name="rate.default",defaultValue = "1.2",mandatory = false)
    BigDecimal getOrderRate();
}
