package com.bragalucas.fdtest.domain;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.bragalucas.fdtest.resources.exception.PasswordConfirmationException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@NotEmpty(message = "O campo nome é obrigátorio.")
	@Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 caracteres e 50 caracteres.")
	private String name;
	
	@Column(unique = true)
	@NotEmpty(message = "O campo email é obrigátorio.")
	@Email(message = "O campo email deve ser válido.")
	private String email;
	
	@NotEmpty(message = "O campo senha é obrigátorio.")
	@Length(min = 6, max = 20, message = "O tamanho deve ser entre 6 caracteres e 20 caracteres.")
	@Transient
	private String password;
	
	private String hashedPassword;
	
	@NotEmpty(message = "O campo confirmação de senha é obrigátorio.")
	@Length(min = 6, max = 20, message = "O tamanho deve ser entre 6 caracteres e 20 caracteres.")
	@Transient
	private String confirmPassword;
	
	
	public User() {
	}

	public User(String id, String name, String email, String password, String confirmPassword) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		if (!this.password.equals(confirmPassword)) {
			throw new PasswordConfirmationException();
		}
		
		this.confirmPassword = confirmPassword;
	}
	
	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
