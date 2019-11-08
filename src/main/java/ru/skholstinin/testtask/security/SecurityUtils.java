package ru.skholstinin.testtask.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.skholstinin.testtask.security.model.Roles;
import ru.skholstinin.testtask.security.model.WebUserDetails;

import java.util.Collection;

public final class SecurityUtils {

    public static boolean isUser() {
        return Roles.ROLE_USER.equals(getAuthenticatedRole());
    }

    public static boolean isSuperuser() {
        return Roles.ROLE_SUPERUSER.equals(getAuthenticatedRole());
    }

    public static boolean hasAuthorizeFor(String... actions) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null == authentication) {
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authentication.getPrincipal() == null || authorities == null) {
            return false;
        }

        for (GrantedAuthority authority : authorities) {
            for (String action : actions) {
                if (authority.getAuthority().equals(action)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getAuthenticatedUsername() {
        return getUserName(SecurityContextHolder.getContext().getAuthentication());
    }

    public static String getAuthenticatedRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null == authentication) {
            return null;
        }

        Object obj = authentication.getPrincipal();
        String role = null;
        if (obj instanceof WebUserDetails) {
            role = ((WebUserDetails) obj).getRole();
        }
        return role;
    }

    public static boolean isComponentHasSecuredAnnotation(Class<?> componentClass) {
        return componentClass.isAnnotationPresent(Secured.class);
    }

    private static String getUserName(Authentication authentication) {
        if (null == authentication) {
            return null;
        }

        Object obj = authentication.getPrincipal();
        String username;
        if (obj instanceof UserDetails) {
            username = ((UserDetails) obj).getUsername();
        } else {
            username = obj.toString();
        }
        return username;
    }

    private SecurityUtils() {
        throw new AssertionError();
    }
}
