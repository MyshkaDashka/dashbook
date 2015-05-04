package by.bsuir.dashka.service;

import by.bsuir.dashka.entity.User;
import by.bsuir.dashka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dashka on 25.04.2015.
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            List<GrantedAuthority> authorities = buildUserAuthority(user);
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("Can't locate user '" + login + "'");
        }
    }

    private List<GrantedAuthority> buildUserAuthority(User user) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        setAuths.add(new SimpleGrantedAuthority(user.getRole()));

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
                                                                                          List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
    }
}