package io.codearte.jfairy.producer.net;

import io.codearte.jfairy.producer.BaseProducer;

import javax.inject.Inject;

/**
 * TODO: Add emails
 */
public class NetworkProducer {

	private final IPNumberProducer ipNumberProducer;

	@Inject
	public NetworkProducer(IPNumberProducer ipNumberProducer) {
		this.ipNumberProducer = ipNumberProducer;
	}

	public String ipAddress() {
		return ipNumberProducer.generate();
	}

	public String url() {
		BaseProducer baseProducer = ipNumberProducer.baseProducer;
		int m = baseProducer.randomBetween(5, 14);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++)
			sb.append("?");
		String domain = baseProducer.letterify(sb.toString());
		return "http://www." + domain + ".com";
	}
}
