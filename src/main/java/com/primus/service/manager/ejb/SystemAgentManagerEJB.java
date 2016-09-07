package com.primus.service.manager.ejb;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.primus.core.util.CompareUtil;
import com.primus.model.SystemAgent;
import com.primus.model.composite.Document;
import com.primus.server.ejb.BasePersistenceManagerEJB;
import com.primus.server.exception.ManagerException;
import com.primus.server.util.PredicateBuilder;
import com.primus.service.manager.local.SystemAgentManagerLocal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SystemAgentManagerEJB extends BasePersistenceManagerEJB<SystemAgent> implements SystemAgentManagerLocal
{
	/**
	 */
	@Override
	public Class<SystemAgent> getModelClass()
	{
		return SystemAgent.class;
	}

	/**
	 */
	@Override
	public SystemAgent get(final Document d)
	{
		SystemAgent model = null;
		try
		{
			final CriteriaBuilder cb = em.getCriteriaBuilder();
			final PredicateBuilder pb = new PredicateBuilder(cb);
			final CriteriaQuery<SystemAgent> cq = cb.createQuery(getModelClass());
			final Root<SystemAgent> systemAgent = cq.from(getModelClass());
//			final Path<Document> document = systemAgent.get("document");
//			final Path<DocumentType> documentType = document.get(Document_.documentType);
//			final Path<Long> documentTypeID = documentType.get(DocumentType_.documentTypeID);
//			final Path<String> documentNumber = document.get(Document_.documentNumber);
//
//			// Expressions.
//			cq.where(cb.and(pb.equal(documentTypeID, d.getDocumentType().getID()), pb.equal(documentNumber, d.getDocumentNumber())));

			// Gets data.
			model = getUnique(cq);
		}
		catch (Throwable t)
		{
			throw new EJBException(t.getMessage());
		}
		return model;
	}

	/**
	 */
	@Override
	public SystemAgent getOrCreate(final Document d, final String firstName, final String lastName) throws ManagerException
	{
		SystemAgent sa = get(d);
		if (CompareUtil.isEmpty(sa))
		{
			sa = save(new SystemAgent(d, firstName, lastName));
		}
		return sa;
	}
}
