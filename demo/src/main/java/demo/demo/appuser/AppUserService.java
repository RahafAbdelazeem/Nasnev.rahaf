package demo.demo.appuser;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final UserRepository  userRepository;
    private final static String USER_NOT_FOUND="user with Emai l%s not found";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        return  userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND)));

    }
}
