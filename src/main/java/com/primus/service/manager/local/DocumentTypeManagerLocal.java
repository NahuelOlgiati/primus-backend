package com.primus.service.manager.local;

import javax.ejb.Local;

import com.primus.model.DocumentType;
import com.primus.server.ejb.BasePersistenceManager;
import com.primus.server.ejb.BaseSimpleManager;

@Local
public interface DocumentTypeManagerLocal
		extends BasePersistenceManager<DocumentType>, BaseSimpleManager<DocumentType> {
}