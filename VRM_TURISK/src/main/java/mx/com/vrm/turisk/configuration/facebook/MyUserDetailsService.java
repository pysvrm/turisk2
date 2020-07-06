package mx.com.vrm.turisk.configuration.facebook;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.com.vrm.turisk.dao.UsuariosDAO;
import mx.com.vrm.turisk.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuariosDAO userRepository;

    public MyUserDetailsService() {
        super();
    }

    // API

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final User user = (User) userRepository.obtenerUsuarioPorNombre(username).getResponse();
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.
        		User(username, user.getPassword(), true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_FACEBOOK")));
    }
}