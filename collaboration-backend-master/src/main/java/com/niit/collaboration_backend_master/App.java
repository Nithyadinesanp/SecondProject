/*package com.niit.collaboration_backend_master;

package com.niit.collaboration_backend_master;


 
 
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}*/





package com.niit.collaboration_backend_master;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.collaboration_backend_master.config.AppContextConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppContextConfig.class);
	}
}
