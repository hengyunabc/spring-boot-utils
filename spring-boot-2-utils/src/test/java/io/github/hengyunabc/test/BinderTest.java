package io.github.hengyunabc.test;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.hengyunabc.bind.SpringBoot2Binder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BinderTest.Application.class, properties = { "ttt.fooKey=foo",
		"ttt.bar-key=bar", "ttt.enabled=false", "ttt.value=123" })
public class BinderTest {

	@Autowired
	private ConfigurableEnvironment environment;

	@Test
	public void test() throws Exception {

		SpringBoot2Binder binder = new SpringBoot2Binder();
		TestConfig testConfig = binder.bind(environment, "ttt", TestConfig.class);

		Assertions.assertThat(testConfig.getFooKey()).isEqualTo("foo");
		Assertions.assertThat(testConfig.getBarKey()).isEqualTo("bar");
		Assertions.assertThat(testConfig.getEnabled()).isEqualTo(false);
		Assertions.assertThat(testConfig.getValue()).isEqualTo(123);
	}

	@SpringBootApplication
	public static class Application {
	}

	public static class TestConfig {
		private String fooKey;
		private String barKey;

		private Boolean enabled;
		private int value;

		public String getFooKey() {
			return fooKey;
		}

		public void setFooKey(String fooKey) {
			this.fooKey = fooKey;
		}

		public String getBarKey() {
			return barKey;
		}

		public void setBarKey(String barKey) {
			this.barKey = barKey;
		}

		public Boolean getEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

}
