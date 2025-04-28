
package com.example.sb1.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb1.Service.PropertyService;
import com.example.sb1.entity.Property;
@RestController 
@RequestMapping("/properties")
public class PropertyController {
	 private final PropertyService propertyservice;
 
   public PropertyController(PropertyService propertyservice) {
	   this.propertyservice=propertyservice;
   }
   
   @PostMapping("/addproperty")
   public Property addnewProperty(@RequestBody Property property) {
	   return propertyservice.addProperty(property);

   }
  
   @GetMapping("/getall") 
   public List<Property> getAllProperties() { 
       return propertyservice.getAllProperties();
   }
   
   @DeleteMapping("/{id}")
   public String deletePropertyById(@PathVariable int id) {
       return propertyservice.deletePropertyById(id);
   }
   // Get Property by ID (GET)
   @GetMapping("/getbyid/{id}")
   public Property getPropertyById(@PathVariable int id) {
       return propertyservice.getPropertyById(id);
   }

   // Update Property by ID (PUT)
   @PutMapping("/update/{id}")
   public Property updateProperty(@PathVariable int id, @RequestBody Property updatedProperty) {
       return propertyservice.updateProperty(id, updatedProperty);
   }


   //    Delete All Properties (DELETE)
   @DeleteMapping("/deleteall")
   public String deleteAllProperties() {
       return propertyservice.deleteAllProperties();
   }



}
