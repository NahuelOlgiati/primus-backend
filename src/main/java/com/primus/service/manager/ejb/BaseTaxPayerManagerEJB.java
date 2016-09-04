package com.primus.service.manager.ejb;

import com.primus.model.TaxPayer;
import com.primus.model.TaxPayerBank;
import com.primus.model.TaxPayerContact;
import com.primus.model.TaxPayerPhone;
import com.primus.service.manager.local.BaseTaxPayerManagerLocal;


public abstract class BaseTaxPayerManagerEJB<T extends TaxPayer> extends TaxAgentManagerEJB<TaxPayerPhone, TaxPayerContact, TaxPayerBank, T>
		implements BaseTaxPayerManagerLocal<T>
{
}