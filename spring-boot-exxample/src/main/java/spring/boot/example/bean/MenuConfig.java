package spring.boot.example.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import spring.boot.example.entity.Menu;

@Component
@ConfigurationProperties("app") // prefix app, find app.* values
@PropertySource("classpath:menu.properties")
public class MenuConfig {
	
	private List<Menu> menus = new ArrayList<>();

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}
