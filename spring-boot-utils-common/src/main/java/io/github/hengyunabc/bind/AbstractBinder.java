package io.github.hengyunabc.bind;

import org.springframework.core.env.ConfigurableEnvironment;

public abstract class AbstractBinder {

	public abstract <T> T bind(ConfigurableEnvironment environment, String prefix, Class<T> type);
}
