package spring.boot.example.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

// su dung annotation @PropertySource de doc nhung file properites tuy chon
@Component
@PropertySource("classpath:global.properties")
@Validated
public class GlobalConfig {

	@Value("${name}")
	@NonNull
	private String name;

	@Value("${website}")
	private String website;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
