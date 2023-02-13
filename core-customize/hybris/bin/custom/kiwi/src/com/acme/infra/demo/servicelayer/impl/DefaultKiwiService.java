package com.acme.infra.demo.servicelayer.impl;

import com.acme.infra.demo.servicelayer.KiwiService;
import com.acme.infra.demo.servicelayer.KiwiDAOService;

import java.util.List;

import com.acme.infra.demo.model.InfraDemoItemModel;

import javax.annotation.Resource;

import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import com.google.common.collect.ImmutableMap;
import de.hybris.platform.site.impl.DefaultBaseSiteService;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class DefaultKiwiService extends DefaultBaseSiteService implements KiwiService {

    private static final Logger LOG = Logger.getLogger(DefaultKiwiService.class);

    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Autowired
    private KiwiDAOService kiwiDAOService;

    public void setKiwiDAOService(KiwiDAOService kiwiDAOService) {
        this.kiwiDAOService = kiwiDAOService;
    }

    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
    {
        this.flexibleSearchService = flexibleSearchService;
    }

    public List<InfraDemoItemModel> findInfraDemoItemByExampleNumberField(Long exampleNumberFieldValue) {
        SearchResult<InfraDemoItemModel> result =
                flexibleSearchService.search(
                        "select {PK} from {InfraDemoItem} where {exampleNumberField} = ?exampleNumberField",
                        ImmutableMap.of("exampleNumberField", exampleNumberFieldValue.toString()));

        List<InfraDemoItemModel> items = result.getResult();
        return items;
    }

    @Override
    public BaseSiteModel getCurrentBaseSite() {
        LOG.info("Calling getCurrentBaseSite of DefaultKiwiService");
        kiwiDAOService.testConnection();
        return super.getCurrentBaseSite();
    }

}
