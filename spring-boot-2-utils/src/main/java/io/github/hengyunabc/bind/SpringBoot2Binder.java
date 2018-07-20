package io.github.hengyunabc.bind;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.ConfigurableEnvironment;

public class SpringBoot2Binder extends AbstractBinder {

	@Override
	public <T> T bind(ConfigurableEnvironment environment, String prefix, Class<T> type) {
		Binder binder = Binder.get(environment);
		Bindable<T> bindable = Bindable.of(type);
		BindResult<T> bindResult = binder.bind(prefix, bindable);
		return bindResult.get();
	}

}
