package za.co.openset.resources;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional
public class TransactionalRollbackInterceptor {
	@Inject
	private EntityManager em;

	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {
		try {
			em.getTransaction().begin();
			return ctx.proceed();
		} finally {
			em.getTransaction().rollback();
            // em.getTransaction().commit();
		}
	}
}

