package com.primus.service.manager.local;

import java.util.List;

import javax.ejb.Local;

import com.ebizlink.pandora2.server.ejb.BaseSimpleManager;
import com.ebizlink.pandora2.server.model.support.QueryHint;
import com.primus.model.NaturalTaxPayer;
import com.primus.model.composite.Document;

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