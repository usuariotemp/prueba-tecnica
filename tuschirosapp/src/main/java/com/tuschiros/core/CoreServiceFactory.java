package com.tuschiros.core;

import com.tuschiros.core.facade.CoreServiceFacade;

public interface CoreServiceFactory {
	public CoreServiceFacade getService(String serviceSelector);
}
