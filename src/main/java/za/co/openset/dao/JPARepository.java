package za.co.openset.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Abstract JPA Repository 
 */
public abstract class JPARepository<T> implements Serializable {
	
	private static final String JPA_LOG_PREFIX = "++++++++++";
	
	protected Logger logger = Logger.getLogger(JPARepository.class.getName());
	
	private Class<T> type;
	
    public abstract EntityManager getEm();

    public JPARepository(Class<T> type) {
		super();
		this.type = type;
	}
	
	protected void create(T object) throws Exception, PersistenceException
	{
		logger.log(Level.FINE, JPA_LOG_PREFIX + "Persisting: {}", object.getClass().getSimpleName());
		
		try{
			getEm().persist(object);
			//getEm().flush();
			logger.log(Level.FINE, JPA_LOG_PREFIX + "Persisting-success: {},id:{}", getIdFieldString(object));
		
		}catch(PersistenceException e){
			throw e;
		}catch (Exception e)
		{
			logger.log(Level.FINE, JPA_LOG_PREFIX + "Error:{}", e);
			throw e;
		}
				
		
	}
	
	protected T update(T object) throws Exception
	{
		logger.log(Level.FINE, JPA_LOG_PREFIX+"Updating: {},id:{}", getIdFieldString(object) );
		try
		{
			//Only the entity returned by the merge operation is a managed entity
			//getEm().flush();
			//object =getEm().merge(object);
			return getEm().merge(object);
			
			
		}
		catch (Exception e)
		{
			logger.log(Level.FINE, "Error:{}", e);
			throw e;
		}
	}
	
	
	protected void delete(T object) throws Exception
	{
		Object id = getIdFieldValue(object);
		logger.log(Level.FINE, JPA_LOG_PREFIX + "Deleting: {},id:{}", id);
		try
		{
			getEm().remove(getEm().getReference(object.getClass(), id));
		}
		catch (Exception e)
		{
			logger.log(Level.FINE, JPA_LOG_PREFIX + "Error:{}", e);
			throw new Exception("Delete failed.", e);
		}
	}
	
	protected T findById(Object id) throws Exception
	{		
		logger.log(Level.FINE, JPA_LOG_PREFIX + "findById: {},value:{}", id.toString());
		T object = (T)getEm().find(type, id);
		
		if (object==null) 
			throw new Exception("Could not find: "+id.getClass().getSimpleName()+" by id:"+id.toString());
		
		return object;
	}
	
	protected List<T> findAll() {
					
		logger.log(Level.FINE, "findAll");
		
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(type);
        Root<T> member = criteria.from(type);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        //criteria.select(member).orderBy(cb.asc(member.get("name")));
        criteria.select(member);
        return getEm().createQuery(criteria).getResultList();
	}
	
	

	/**
	 * Exact match 
	 */
	protected List<T> findByFieldName(String fieldname, Object id) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		
        CriteriaQuery<T> criteria = cb.createQuery(type);
        Root<T> member = criteria.from(type);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(member).where(cb.equal(member.get(fieldname), id));
        return getEm().createQuery(criteria).getResultList();
	}

    protected List<T> findByFieldName(Class<T> clazz, String fieldname, Object id) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();

        CriteriaQuery<T> criteria = cb.createQuery(clazz);
        Root<T> member = criteria.from(clazz);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(member).where(cb.equal(member.get(fieldname), id));
        return getEm().createQuery(criteria).getResultList();
	}
	
	protected T findEntityByFieldName(String fieldname, Object id) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		
        CriteriaQuery<T> criteria = cb.createQuery(type);
        Root<T> member = criteria.from(type);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(member).where(cb.equal(member.get(fieldname), id));
        return getEm().createQuery(criteria).getSingleResult();
	}

	protected T findEntityByFieldName (Map<String, Object> map) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();

		CriteriaQuery<T> criteria = cb.createQuery(type);
		Root<T> member = criteria.from(type);

		List<Predicate> criteriaList = new ArrayList<Predicate>();

		criteria.select(member);
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			Predicate predicate = cb.equal(member.get(entry.getKey()), entry.getValue());
			criteriaList.add(predicate);
		}
		criteria.where(cb.and(criteriaList.toArray(new Predicate[0])));
		return getEm().createQuery(criteria).getSingleResult();
	}

	protected List<T> findByFieldNameLikeMatch(String fieldName, Object id){
//		CriteriaBuilder cb = getEm().getCriteriaBuilder();
//		
//		CriteriaQuery<T> criteria = cb.createQuery(type);
//		Root<T> member = criteria.from(type);
//		
//		criteria.select(member).where(cb.like(member.get(fieldName, id)));
		
		CriteriaBuilder builder = getEm().getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(type);
		//EntityType<T> entityType = getEm().getMetamodel().entity(type);
		Root<T> root = query.from(type); 
		
		
		query.where(builder.like(root.<String>get(fieldName), "%" + id + "%"));
		
		return getEm().createQuery(query).getResultList();
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
    
    protected Object getEntityByQuery(String queryString, Map<String, Object> parameters) throws Exception {
    	Object obj = null;
        Query query = createQuery(queryString, parameters);
    	
    	try {
			obj = query.getSingleResult();
		} catch (Exception e) {
			throw new Exception("Could not retrieve entity for Query. Error: " + e.getMessage());
		}

		return obj;
    }
    
    protected List getListByQuery(String queryString, Map<String, Object> parameters) throws Exception {
        Query query = createQuery(queryString, parameters);
    	
    	try {
    		List list = query.getResultList();
    		logger.log(Level.FINE, "Result count from query:" + list.size());
    		return list;
		} catch (Exception e) {
			throw new Exception(
					"Could not retrieve entity for Query. Error: " + e.getMessage());
		}
    }

    protected Query createQuery(String queryString, Map<String, Object> parameters) {
        Query query = getEm().createQuery(queryString);

        if(parameters != null && !parameters.isEmpty()) {
            for(String name : parameters.keySet()) {
                query.setParameter(name, parameters.get(name));
            }
        }
        return query;
    }

    public Object getObjectByNativeQuery(String queryString, Map<String, Object> parameters, boolean callable) throws Exception {
    	Object obj = null;
    	Query query = getEm().createNativeQuery(queryString);
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
    
    public List<String> getListByNativeQuery(String queryString, Map<String, Object> parameters, boolean callable) throws Exception {
    	List<String> list = null;
    	Query query = getEm().createNativeQuery(queryString);
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
			throw new Exception("Could not retrieve items for Query. Error: " + e.getMessage());
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
