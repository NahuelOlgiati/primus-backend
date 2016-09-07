package com.primus.server.model.mpi;

import com.primus.server.model.BaseModel;

public interface Clonable<T extends BaseModel>
{
	/**
	 */
	public abstract T getClone();
}