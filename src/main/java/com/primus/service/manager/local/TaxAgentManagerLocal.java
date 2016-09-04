package com.primus.service.manager.local;

import com.primus.model.TaxAgent;
import com.primus.model.TaxAgentBank;
import com.primus.model.TaxAgentContact;
import com.primus.model.TaxAgentPhone;

public interface TaxAgentManagerLocal<P extends TaxAgentPhone, C extends TaxAgentContact, B extends TaxAgentBank, T extends TaxAgent<P, C, B>>
		extends AgentManagerLocal<T>
{
}