package br.com.salaoiscool.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 534739221063078285L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name = "estabelecimento_id", referencedColumnName = "id", foreignKey= @ForeignKey(name = "fk_usuario_estabelecimento"))
	private Estabelecimento estabelecimento;
	

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(inverseJoinColumns = { @JoinColumn(name = "acesso_id",foreignKey= @ForeignKey(name = "fk_acesso_usuario")) }, joinColumns = { @JoinColumn(name = "usuario_id",foreignKey= @ForeignKey(name = "fk_usuario_acesso")) })
	private List<Acesso> acessos;
	
	
	//Security
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getAcessos();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}
