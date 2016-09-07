package com.primus.service.manager.local;

import java.util.List;

import javax.ejb.Local;

import com.primus.model.NaturalTaxPayer;
import com.primus.model.composite.Document;
import com.primus.server.ejb.BaseSimpleManager;
import com.primus.server.model.support.QueryHint;

@Local
public interface NaturalTaxPayerManagerLocal extends BaseTaxPayerManagerLocal<NaturalTaxPayer>, BaseSimpleManager<NaturalTaxPayer>
{
	/**
	 */
	public abstract List<NaturalTaxPayer> getNaturalTaxPayerByDocument(final Document document, final QueryHint queryHint);

	/**
	 */
	public abstract boolean getDuplicatedException(final Document document, final NaturalTaxPayer naturalTaxPayer);
}