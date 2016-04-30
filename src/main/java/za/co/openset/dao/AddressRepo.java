package za.co.openset.dao;

import za.co.openset.model.Address;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AddressRepo extends AbstractJPARepository<Address> {
    @Inject
    private EntityManager entityManager;

    public AddressRepo(){
        super(Address.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Address address) throws Exception {

        if (address.getAddressId() == null)
            super.create(address);
        else
            super.update(address);

    }

    public Long persist(Address address) {
        entityManager.persist(address);
        return address.getAddressId();
    }

    public Address findById(Long id) throws Exception {
        return super.findById(id);
    }


    public List<Address> findAll() {
        return super.findAll();
    }

    public List<Address> findByParent(Long parentId) {
        return findByFieldName("parentId", parentId);
    }

    /*
    public Address findByParent(Long parentId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Address> criteria = cb.createQuery(Address.class);
        Root<Address> member = criteria.from(Address.class);

        criteria.select(member).where(
                cb.and(
                        cb.equal(member.get("parentId"), parentId)
                        //cb.equal( member.get("businessContextType"),businessContextType)
                )
        );

        try {
            return entityManager.createQuery(criteria).getSingleResult();
        } catch (NoResultException noResultExc) {
            return null;
        }
    }*/


}
