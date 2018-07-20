package io.github.hengyunabc.bind;

import org.springframework.core.env.ConfigurableEnvironment;

public class BinderUtils {

	private static AbstractBinder binder = null;

	static {
		try {
			Class.forName("org.springframework.boot.context.properties.bind.Binder");
			binder = new SpringBoot2Binder();
		} catch (ClassNotFoundException e) {
			try {
				Class.forName("org.springframework.boot.bind.RelaxedDataBinder");
				binder = new SpringBoot1Binder();
			} catch (ClassNotFoundException e1) {
				// ignore
			}
		}
	}

	public static <T> T bind(ConfigurableEnvironment environment, String prefix, Class<T> type) {
		if (binder != null) {
			return binder.bind(environment, prefix, type);
		} else {
			throw new IllegalStateException(
					"Can not load class org.springframework.boot.context.properties.bind.Binder or org.springframework.boot.bind.RelaxedDataBinder, binder can not work.");
		}
	}
}
