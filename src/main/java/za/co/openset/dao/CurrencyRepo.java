package za.co.openset.dao;

import za.co.openset.model.Currency;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class CurrencyRepo extends AbstractJPARepository<Currency> {
    @Inject
    private EntityManager entityManager;

    public CurrencyRepo(){
        super(Currency.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }


}
