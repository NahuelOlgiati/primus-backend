package com.primus.service.manager.local;

import javax.ejb.Local;

import com.ebizlink.pandora2.server.ejb.BasePersistenceManager;
import com.ebizlink.pandora2.server.ejb.BaseSimpleManager;
import com.primus.model.DocumentType;

@Local
public interface DocumentTypeManagerLocal
		extends BasePersistenceManager<DocumentType>, BaseSimpleManager<DocumentType> {
}