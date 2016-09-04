package com.primus.service.manager.local;

import com.primus.model.TaxPayer;
import com.primus.model.TaxPayerBank;
import com.primus.model.TaxPayerContact;
import com.primus.model.TaxPayerPhone;

public interface BaseTaxPayerManagerLocal<T extends TaxPayer> extends TaxAgentManagerLocal<TaxPayerPhone, TaxPayerContact, TaxPayerBank, T>
{
}