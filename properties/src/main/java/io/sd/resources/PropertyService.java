package io.sd.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.sd.entities.Property;

@Service
public class PropertyService {

	private static List<Property> properties;
	
	static {
		properties = new ArrayList<Property>();
	}
	
	public List<Property> getAll() {
		return properties;
	}
	
	public Optional<Property> get(String id) {
		return properties.stream().filter(property -> property.getId().equals(id)).findAny();
	}
	
	public void add(Property property) {
		if (properties !=  null) {
			properties.add(property);
		}
	}
}
