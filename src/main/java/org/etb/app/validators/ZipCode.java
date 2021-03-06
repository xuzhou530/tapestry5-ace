// Copyright 2008 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.etb.app.validators;

import java.util.regex.Pattern;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.ioc.MessageFormatter;
import org.apache.tapestry5.services.FormSupport;
import org.apache.tapestry5.validator.AbstractValidator;

/**
 * 邮政编码验证
 * 
 * @author AlexHuang
 * @email huangyu407@qq.com
 */
public class ZipCode extends AbstractValidator<Void, String> {
	
	private static final Pattern PATTERN = Pattern.compile("^[0-9]{6}$");

	public ZipCode() {
		super(null, String.class, "zipcode");
	}

	public void render(Field field, Void constraintValue,
			MessageFormatter formatter, MarkupWriter markupWriter,
			FormSupport formSupport) {
		formSupport.addValidation(field, "zipCode",
				buildMessage(formatter, field), null);
	}

	private String buildMessage(MessageFormatter formatter, Field field) {
		return formatter.format(field.getLabel());
	}

	public void validate(Field field, Void constraintValue,
			MessageFormatter formatter, String value)
			throws ValidationException {
		if (!PATTERN.matcher(value).matches())
			throw new ValidationException(buildMessage(formatter, field));
	}
}
