package com.daniel.atoche.pe.ec3danielatoche.security;

import java.util.ArrayList;
import java.util.List;

import com.daniel.atoche.pe.ec3danielatoche.model.UsuarioCliente;
import com.daniel.atoche.pe.ec3danielatoche.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioCliente usu = repository.findByUsuario(username);
        
        if( usu != null) {
            
            List<GrantedAuthority> listGranted = new ArrayList<>();
            GrantedAuthority granted =new SimpleGrantedAuthority(usu.getRol());
            listGranted.add(granted);
                        
            return new User(
                    usu.getUsuario(),  
                    usu.getPassword(),
                    listGranted);
        }else {
            throw new UsernameNotFoundException("Usuario no existe " + username);
        }
	}

}
