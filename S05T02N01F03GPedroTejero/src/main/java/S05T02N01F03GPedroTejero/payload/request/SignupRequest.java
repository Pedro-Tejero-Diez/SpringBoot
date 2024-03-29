package S05T02N01F03GPedroTejero.payload.request;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class SignupRequest {

	private String username;

	private List<String> role;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRole() {
		return this.role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}
}
