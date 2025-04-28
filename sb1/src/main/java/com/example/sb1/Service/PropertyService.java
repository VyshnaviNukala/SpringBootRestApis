package com.example.sb1.Service;

import com.example.sb1.entity.Property;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {
    private static int counter = 1;
    private final List<Property> propertylist = new ArrayList<>();

    public Property addProperty(Property property) {
        property.setId(counter++);
        propertylist.add(property);
        return property;
    }
 
   
    public List<Property> getAllProperties() {
        return propertylist;
    }

    public String deletePropertyById(int id) {
        boolean removed = propertylist.removeIf(property -> property.getId() == id);
        return removed ? "Property deleted successfully." : "Property not found.";
    }
        
//        public String deletePropertyById(int id) {
//            System.out.println("Deleting property with ID: " + id);
//            
//            for (Property property : propertylist) {
//                if (property.getId() == id) {
//                    propertylist.remove(property);
//                    return "Property deleted successfully.";
//                }
//            }
//            
//            return "Property not found.";
//        } 
    
    public Property getPropertyById(int id) {
        System.out.println("Fetching property with ID: " + id);
        System.out.println("Current property list: " + propertylist);
        
        return propertylist.stream()
                .filter(property -> property.getId() == id)
                .findFirst()
                .orElse(null);
    }
        
//        public Property getPropertyById(int id) {
//            System.out.println("Fetching property with ID: " + id);
//            System.out.println("Current property list: " + propertylist);
//            
//            for (Property property : propertylist) {
//                if (property.getId() == id) {
//                    return property;
//                }
//            }
//            
//            return null; // If no property with the given ID is found
//        }

    
    // Update Property by ID
    public Property updateProperty(int id, Property updatedProperty) {
        System.out.println("Updating Property ID: " + id);
        System.out.println("Existing properties: " + propertylist);

        for (Property property : propertylist) {
            if (property.getId() == id) {
                property.setAddress(updatedProperty.getAddress());
                property.setDescription(updatedProperty.getDescription());
                return property;
            }
        }
        
        throw new RuntimeException("Property with ID " + id + " not found.");
    }


    
    // Delete All Properties
  public String deleteAllProperties() {
      propertylist.clear();
      return "All properties deleted successfully.";
  }
}


