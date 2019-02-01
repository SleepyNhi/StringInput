import java.util.*;
public class HelloWorld
{
  public static void main(String[] args)
  {
    
    String str1 = "--help --count 555";
    String[] stringArray = str1.split("\\s+");
    System.out.println( stringArray.length );
    ArrayList<String> check = new ArrayList<String>();
    check.add("--help");
    check.add("--name");
    check.add("--count");
    	
    	boolean validFlag = true; 
    	boolean validHelp = false;
            
    	int trigger = 0; 
    
        for (int i = 0; i < stringArray.length ; i++) {
          
          if(check.contains(stringArray[i]) && trigger == 0){
            trigger = 1;
            if (stringArray[i].equals( "--help")){
            	validHelp = true;
              	
            }
            continue;
          }
          
          if(check.contains(stringArray[i]) && trigger == 1){
          	continue;
          }
          
          if (trigger == 1){
          
            if(stringArray[i-1].equals( "--name")) {
                if ((stringArray[i].length() >= 3) && (stringArray[i].length() <= 10)){
                  trigger = 0;
                  continue;
            	}
            
            } else if (stringArray[i-1].equals("--count")){
              int test = Integer.parseInt(stringArray[i]);
                if ((test >= 10) && (test <= 100)){
                    trigger = 0;
                  	continue;
                }
             
            }
            System.out.println("Invalid Entry");
            validFlag= false;
            break;
                    
          }
  
          
          
              
  		}
    
    	System.out.println("Valid help flag:" + validHelp + " Valid input flag: " + validFlag);
    	if ( validFlag ){
          if (validHelp){
            System.out.println("Entry is true and help is requested");
          } else System.out.println("Entry is true");
  		} else System.out.println("Invalid entry");
  }
}

