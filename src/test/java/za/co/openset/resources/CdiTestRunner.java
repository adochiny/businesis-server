package za.co.openset.resources;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * Custom JUnit runner that instantiates test classes with CDI.
 */
public class CdiTestRunner extends BlockJUnit4ClassRunner {
	static {
		CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
		cdiContainer.boot();
	}

	public CdiTestRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}

	@Override
	protected Object createTest() throws Exception {
		return BeanProvider.getContextualReference(getTestClass().getJavaClass());
	}
}
