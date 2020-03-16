package spring.boot.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.boot.example.bean.GlobalConfig;
import spring.boot.example.bean.MenuConfig;
import spring.boot.example.service.HelloService;

@Controller
public class BaseController {

	@Autowired
	private GlobalConfig globalConfig;
	
	@Autowired
	private MenuConfig menuConfig;
	
	@Autowired
	HelloService helloService;
	
	@Value("${message}")
	private String message;
	
	@RequestMapping("/home")
	public String index(Model model) {
		model.addAttribute("name", globalConfig.getName());
		model.addAttribute("website", globalConfig.getWebsite());
		model.addAttribute("message", message);
		model.addAttribute("menus", menuConfig.getMenus());
		model.addAttribute("service", helloService.hello());
		return "index";
	}
}
