package com.primus.service.manager.ejb;

import com.primus.model.TaxAgent;
import com.primus.model.TaxAgentBank;
import com.primus.model.TaxAgentContact;
import com.primus.model.TaxAgentPhone;
import com.primus.service.manager.local.TaxAgentManagerLocal;

public abstract class TaxAgentManagerEJB<P extends TaxAgentPhone, C extends TaxAgentContact, B extends TaxAgentBank, T extends TaxAgent<P, C, B>>
		extends AgentManagerEJB<T> implements TaxAgentManagerLocal<P, C, B, T>
{
}