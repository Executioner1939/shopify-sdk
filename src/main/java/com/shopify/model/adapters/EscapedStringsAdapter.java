package com.shopify.model.adapters;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Collection;
import java.util.stream.Collectors;

public class EscapedStringsAdapter extends XmlAdapter<Collection<String>, Collection<String>> {

	@Override
	public Collection<String> unmarshal(final Collection<String> escapedStrings) throws Exception {
		return (escapedStrings == null) ? null
				: escapedStrings.stream().map(StringEscapeUtils::unescapeHtml4).collect(Collectors.toList());
	}

	@Override
	public Collection<String> marshal(final Collection<String> unescapedStrings) throws Exception {
		return unescapedStrings;
	}

}
