
package com.niit.ni.nirest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String indexPage()
	{
		return "index";
	}
	
}
