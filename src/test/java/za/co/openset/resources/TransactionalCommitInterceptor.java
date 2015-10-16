package za.co.openset.resources;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional(defaultRollback = false)
public class TransactionalCommitInterceptor {
	@Inject
	private EntityManager em;

	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {
		em.getTransaction().begin();
		Object result = ctx.proceed();
		em.getTransaction().commit();
		return result;
	}
}

