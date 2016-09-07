package com.ebizlink.pandora2.server.model.mpi;

import com.ebizlink.pandora2.server.model.BaseModel;

public interface Clonable<T extends BaseModel>
{
	/**
	 */
	public abstract T getClone();
}