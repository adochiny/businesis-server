package za.co.openset.dao;

/**
 * Created by adonis on 2015/06/04.
 *
 */

import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


/*
 * Abstract JPA Repository
 */
// TODO: Remove this and replace with AbstractRepository from pl-common-repo jar.
public abstract class AbstractJPARepository<T> implements Serializable {

    private static final String JPA_LOG_PREFIX = "++++++++++";

    protected Logger logger = Logger.getLogger(AbstractJPARepository.class.getName());

    private Class<T> type;

    protected abstract EntityManager getEntityManager();

    public AbstractJPARepository(Class<T> type) {
        super();
        this.type = type;
    }

    public T create(T object) throws Exception, PersistenceException
    {
        logger.fine(JPA_LOG_PREFIX + "Persisting: {} " + object.getClass().getSimpleName());

        try{
            getEntityManager().persist(object);
            //getEntityManager().flush();
            logger.fine(JPA_LOG_PREFIX + "Persisting-success: {},id:{} " +  object.getClass().getSimpleName() + getIdFieldString(object));

        }catch(PersistenceException e){
            throw e;
        }catch (Exception e)
        {
            logger.log(Level.SEVERE, JPA_LOG_PREFIX + "Error:{}", e);
            throw e;
        }

        return object;
    }

    public T update(T object) throws Exception
    {
        logger.fine(JPA_LOG_PREFIX + "Updating: {},id:{} " +  object.getClass().getSimpleName() + getIdFieldString(object));
        try
        {
            //Only the entity returned by the merge operation is a managed entity
            //getEntityManager().flush();
            //object =getEntityManager().merge(object);
            return getEntityManager().merge(object);


        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Error:{} " + e);
            throw e;
        }
    }


    public void delete(T object) throws RepositoryException
    {
        Object id = getIdFieldValue(object);
        logger.fine(JPA_LOG_PREFIX + "Deleting: {},id:{} " +  object.getClass().getSimpleName() + id);
        try
        {
            getEntityManager().remove(getEntityManager().getReference(object.getClass(), id));
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, JPA_LOG_PREFIX+"Error:{}",e);
            throw new RepositoryException("Delete failed.", e);
        }
    }

    public T findById(Object id) throws RepositoryException
    {
        logger.fine(JPA_LOG_PREFIX + "findById: {},value:{} " +  id.getClass().getSimpleName() + id.toString());
        T object = (T)getEntityManager().find(type, id);

        if (object==null)
            throw new RepositoryException("Could not find: "+id.getClass().getSimpleName()+" by id:"+id.toString());

        return object;
    }

    public List<T> findAll() {

        logger.fine("findAll");

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(type);
        Root<T> member = criteria.from(type);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        //criteria.select(member).orderBy(cb.asc(member.get("name")));
        criteria.select(member);
        return getEntityManager().createQuery(criteria).getResultList();
    }



    public List<T> findByFieldName(String fieldname, Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<T> criteria = cb.createQuery(type);
        Root<T> member = criteria.from(type);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(member).where(cb.equal(member.get(fieldname), id));
        return getEntityManager().createQuery(criteria).getResultList();
    }

    public List<T> findByFieldName(Class<T> clazz, String fieldname, Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<T> criteria = cb.createQuery(clazz);
        Root<T> member = criteria.from(clazz);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(member).where(cb.equal(member.get(fieldname), id));
        return getEntityManager().createQuery(criteria).getResultList();
    }

    public T findEntityByFieldName(String fieldname, Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<T> criteria = cb.createQuery(type);
        Root<T> member = criteria.from(type);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(member).where(cb.equal(member.get(fieldname), id));
        return getEntityManager().createQuery(criteria).getSingleResult();
    }

    public T findEntityByFieldName (Map<String, Object> map) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<T> criteria = cb.createQuery(type);
        Root<T> member = criteria.from(type);

        List<Predicate> criteriaList = new ArrayList<Predicate>();

        criteria.select(member);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Predicate predicate = cb.equal(member.get(entry.getKey()), entry.getValue());
            criteriaList.add(predicate);
        }
        criteria.where(cb.and(criteriaList.toArray(new Predicate[0])));
        return getEntityManager().createQuery(criteria).getSingleResult();
    }

    public List<T> findByFieldNameLikeMatch(String fieldName, Object id){
//		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
//
//		CriteriaQuery<T> criteria = cb.createQuery(type);
//		Root<T> member = criteria.from(type);
//
//		criteria.select(member).where(cb.like(member.get(fieldName, id)));

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        //EntityType<T> entityType = getEntityManager().getMetamodel().entity(type);
        Root<T> root = query.from(type);


        query.where(builder.like(root.<String>get(fieldName), "%" + id + "%"));

        return getEntityManager().createQuery(query).getResultList();
    }

    /**
     * Get string representation of Object id fields, their name and value
     * @param instance
     * @return
     */
    private String getIdFieldString(Object instance)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Id Fields[");


        Field[] fields = instance.getClass().getDeclaredFields();
        AccessibleObject.setAccessible(fields,true);

        for(Field f: fields)
            if (f.getName().toLowerCase().endsWith("id"))
            {
                Object value = null;
                try {
                    value = f.get(instance);
                    sb.append("field:"+f.getName());
                    sb.append(" value:"+ ((value==null) ? "NULL" : value.toString()) );
                    sb.append("\n");
                } catch (IllegalAccessException e) {continue;}

            }

        sb.append("]");

        return sb.toString();
    }

    private Object getIdFieldValue(Object instance)
    {
        Field[] fields = getAllDeclaredFields(instance.getClass(), new ArrayList<Field>()).toArray(new Field[] {});

        instance.getClass().getSuperclass();
        AccessibleObject.setAccessible(fields,true);
        Object value = null;

        for(Field f: fields)
            if (f.getName().toLowerCase().equals("id"))
            {
                try {
                    value = f.get(instance);
                } catch (IllegalAccessException e) {continue;}
            }

        return value;
    }

    public Object getEntityByQuery(String queryString, Map<String, Object> parameters) throws RepositoryException {
        Object obj = null;
        Query query = createQuery(queryString, parameters);

        try {
            obj = query.getSingleResult();
        } catch (Exception e) {
            throw new RepositoryException("Could not retrieve entity for Query. Error: " + e.getMessage());
        }

        return obj;
    }

    public List getListByQuery(String queryString, Map<String, Object> parameters) throws RepositoryException {
        Query query = createQuery(queryString, parameters);

        try {
            List list = query.getResultList();
            logger.fine("Result count from query:" + list.size());
            return list;
        } catch (Exception e) {
            throw new RepositoryException(
                    "Could not retrieve entity for Query. Error: " + e.getMessage());
        }
    }

    public Query createQuery(String queryString, Map<String, Object> parameters) {
        Query query = getEntityManager().createQuery(queryString);

        if(parameters != null && !parameters.isEmpty()) {
            for(String name : parameters.keySet()) {
                query.setParameter(name, parameters.get(name));
            }
        }
        return query;
    }

    public Object getObjectByNativeQuery(String queryString, Map<String, Object> parameters, boolean callable) throws Exception {
        Object obj = null;
        Query query = getEntityManager().createNativeQuery(queryString);
        if(callable) {
            query.setHint("org.hibernate.callable", "true");
        }

        if(parameters != null && !parameters.isEmpty()) {
            for(String name : parameters.keySet()) {
                query.setParameter(name, parameters.get(name));
            }
        }

        try {
            obj = query.getSingleResult();

        } catch (Exception e) {
            throw new Exception("Could not retrieve entity for Query. Error: " + e.getMessage());
        }

        return obj;
    }

    public List<String> getListByNativeQuery(String queryString, Map<String, Object> parameters, boolean callable) throws RepositoryException {
        List<String> list = null;
        Query query = getEntityManager().createNativeQuery(queryString);
        if(callable) {
            query.setHint("org.hibernate.callable", "true");
        }

        if(parameters != null && !parameters.isEmpty()) {
            for(String name : parameters.keySet()) {
                query.setParameter(name, parameters.get(name));
            }
        }

        try {
            list = query.getResultList();
        } catch (Exception e) {
            throw new RepositoryException("Could not retrieve items for Query. Error: " + e.getMessage());
        }

        return list;
    }

    /**
     * Recursive function to get all declared fields, including inherited ones. The recursion will stop when the superclass is of java.lang.Object
     * @param clazz
     * @param allFields
     * @return
     */
    private List<Field> getAllDeclaredFields(Class clazz, List<Field> allFields) {
        Class superClass = clazz.getSuperclass();
        if (!superClass.equals(Object.class)) {
            allFields.addAll(getAllDeclaredFields(superClass, allFields));
        }
        allFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        return allFields;
    }

}

