/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.
 */

public class Accumulator {

    /**
      @return the concatenation of all the Strings
      in the \list that begin with \prefix,
      each followed by a space.
      
      --------------------------------
      
      Stumbling block 0
      
      Java protects a programmer against applying a method
      to elements in list when some elements of the list might
      omit support for a particular operation.
      
      Predict: This protection is implemented by the compiler
      			- the compiler will stumble over the error
      			
      			
      Error Code:
      
        for (int i = 0; i < list.size(); i++) {
        	if ( list.get(i).startsWith( prefix)) {
        		result += list.get(i);
        	}
        }
        
        return result; 
        
      Error message: The following attempt to violate the
      				 restriction is expected to result in
      				 the error -
      	
      	Accumulator.java:40: error: cannot find symbol
        	if ( list.get(i).startsWith( prefix)) {
        	                ^
  		symbol:   method startsWith(String)
  		location: class Object
  		
  	  --------------------------------	
  		
  	  Workaround 0
  	  	
  	  A programmer should expect to be able to work around
  	  the stumbling block because the Java compiler knows
  	  the type of an element.

	  Java's instanceof operator identifies the type of an
	  element to the Java compiler.
	  
	  --------------------------------
	  
	  Stumbling block 1
	  
	  Use of the operator alone is insufficient because the
	  Java compiler continues to stumble over the previous
	  stumbling block of protection against mis-applying a method. 
	  
	  Code that illustrates the use of the operator:
	  
	  	for (int i = 0; i < list.size(); i++) {
        	if ( list.get(i)
        		instanceof
        		String && list.get(i).startsWith( prefix)
        		){
        		result += list.get(i);
        	}
        }
        
        return result; 
        
      Predicted Error Message: 
      
      	Accumulator.java:71: error: cannot find symbol
        	if ( list.get(i)
        	instanceof
        	String && list.get(i).startsWith( prefix))
        						 ^
        	{
  		symbol:   method startsWith(String)
  		location: class Object
  		
  	  --------------------------------
	  
	  Workaround 1 & Stumbling block 2
	  
	  Java provides a casting facility that a programmer
	  uses to tell the Java compiler that they are using a
	  subclass's method on an object for which a reference
	  is stored in a super-type variable. 
	  
	  Code that illustrates the use of the operator:
	  
	  	for (int i = 0; i < list.size(); i++) {
        	if ( ((String)list.get(i)).startsWith( prefix)) {
        		result += list.get(i);
        	}
        }
        
        return result; 
        
      But use of that facility alone is insufficient because the
      JVM stumbles over casting types without any relation to each other
      (they do not share a superclass; do not have a parent-child class
      relationship).
      
      Predicted Error Message:
      	Exception in thread "main" java.lang.ClassCastException: class java.lang.Double cannot be cast to class java.lang.String (java.lang.Double and java.lang.String are in module java.base of loader 'bootstrap')
		at Accumulator.catElementsStartingWith(Accumulator.java:118)
		at UserOfList.main(UserOfList.java:59)
		
	  --------------------------------
	  
	  Workaround 2
	  
	  A programmer can combine use of the operator and the facility to apply a method to exactly those elements in the list that support the method. 
	  
     */
	
    public static String catElementsStartingWith(
        List_inArraySlots list
      , String prefix
      ) {
        String result = "";
        
        for (int i = 0; i < list.size(); i++) {
        	if ( list.get(i)
        		instanceof
        		String && ((String)list.get(i)).startsWith( prefix)
        		) {
        		result += list.get(i);
        	}
        }
        
        return result; 
    }


    /**
      @return a list of each of the Double elements
      from the \list whose value is "finite".
     */
     public static List_inArraySlots finites(
         List_inArraySlots list
       ) {
    	 List_inArraySlots newList = new List_inArraySlots();
    	 for (int i = 0; i < list.size(); i++) {
    		 if ( list.get(i)
    			instanceof
    			Double && !((Double)list.get(i)).isInfinite()
    			) {
    			 newList.add(list.get(i));
    		 }
    	 }
    	 return newList;
     }
}
