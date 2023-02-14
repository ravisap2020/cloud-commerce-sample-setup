package com.acme.infra.demo.servicelayer.impl;

import com.acme.infra.demo.model.InfraDemoItemModel;
import com.acme.infra.demo.servicelayer.KiwiDAOService;
import com.acme.infra.demo.servicelayer.KiwiService;
import com.google.common.collect.ImmutableMap;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
public class DefaultKiwiDAOService implements KiwiDAOService {

    private static final Logger LOG = Logger.getLogger(DefaultKiwiDAOService.class);

    @Override
    public void testConnection() {
        LOG.info("Calling the testConnection method of DefaultKiwiDAOService");
    }
}
