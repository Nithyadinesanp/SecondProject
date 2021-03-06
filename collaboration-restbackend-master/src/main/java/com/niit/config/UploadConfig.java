package com.niit.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.niit.service.UploadServiceDaoImpl;

@ApplicationPath("/rest")
public class UploadConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(UploadServiceDaoImpl.class);
		s.add(MultiPartFeature.class);
		return s;
	}

}