package io.codearte.jfairy.producer.person.locale.sv;

import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.DateProducer;
import io.codearte.jfairy.producer.person.NationalIdentityCardNumberProvider;
import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Inject;

/**
 * Swedish Identity Card Number (random number implementation)
 */
public class SvNationalIdentityCardNumberProvider implements NationalIdentityCardNumberProvider {

	private final DateProducer dateProducer;
	private final BaseProducer baseProducer;

	@Inject
	public SvNationalIdentityCardNumberProvider(DateProducer dateProducer, BaseProducer baseProducer) {
		this.dateProducer = dateProducer;
		this.baseProducer = baseProducer;
	}

	@Override
	public String get() {
		return RandomStringUtils.randomNumeric(8);
	}
}
