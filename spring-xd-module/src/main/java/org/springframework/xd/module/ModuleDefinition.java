/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.xd.module;

import java.net.URL;
import java.util.Properties;

import org.springframework.core.io.DescriptiveResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

/**
 * Defines a module.
 * 
 * @author Gary Russell
 * 
 */
public class ModuleDefinition {

	private final String name;

	private final String type;

	private final Resource resource;

	private volatile Properties properties;

	private final URL[] classpath;

	public ModuleDefinition(String name, String moduleType) {
		this(name, moduleType, new DescriptiveResource("Dummy resource"));
	}

	public ModuleDefinition(String name, String type, Resource resource) {
		this(name, type, resource, null);
	}

	public ModuleDefinition(String name, String type, Resource resource, URL[] classpath) {
		Assert.hasLength(name, "name cannot be blank");
		Assert.hasLength(type, "type cannot be blank");
		Assert.notNull(resource, "resource cannot be null");
		this.resource = resource;
		this.name = name;
		this.type = type;
		this.classpath = classpath != null && classpath.length > 0 ? classpath : null;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Resource getResource() {
		return resource;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public URL[] getClasspath() {
		return classpath;
	}

}
