package io.sd.resources;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.sd.entities.Property;

@RestController
@RequestMapping("/properties")
public class PropertyResource {
	private final Logger logger = LoggerFactory.getLogger(PropertyResource.class);
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping("/property")
	public List<Property> getProperties() {
		log();
		return propertyService.getAll();
	}
	
	@GetMapping("/property/{id}")
	public Property getProperty(@PathVariable("id") String id) {
		log();
		return propertyService.get(id).get();
	}
	
	@PostMapping("property")
	public void addProperty(@RequestBody Property property) {
		log();
		propertyService.add(property);
	}
	
	public void log() {
		String host = "";
		try {
			host = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String podName = System.getenv("HOSTNAME");
		logger.info("Pod " + podName + " or " + host + " is working..");
	}
}
