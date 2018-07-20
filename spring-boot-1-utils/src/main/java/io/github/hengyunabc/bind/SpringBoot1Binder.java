package io.github.hengyunabc.bind;

import org.springframework.boot.bind.PropertySourcesPropertyValues;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.core.env.ConfigurableEnvironment;

public class SpringBoot1Binder extends AbstractBinder {

	@Override
	public <T> T bind(ConfigurableEnvironment environment, String prefix, Class<T> type) {
		T instance;
		try {
			instance = type.newInstance();
		} catch (Throwable e) {
			throw new IllegalArgumentException(e);
		}
		new RelaxedDataBinder(instance, prefix)
				.bind(new PropertySourcesPropertyValues(environment.getPropertySources()));
		return instance;
	}

}
