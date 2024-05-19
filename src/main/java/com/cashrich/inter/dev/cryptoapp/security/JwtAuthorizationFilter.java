// package com.cashrich.inter.dev.cryptoapp.security;

// import java.io.IOException;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
// import io.jsonwebtoken.Jwts;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

//     private static final String SECRET_KEY = "your_secret_key";
//     private UserDetailsService userDetailsService;

//     public JwtAuthorizationFilter(AuthenticationManager authManager, UserDetailsService userDetailsService) {
//         super(authManager);
//         this.userDetailsService = userDetailsService;
//     }

//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//             throws ServletException, IOException {
//         String header = request.getHeader("Authorization");

//         if (header == null || !header.startsWith("Bearer ")) {
//             chain.doFilter(request, response);
//             return;
//         }

//         String token = header.replace("Bearer ", "");
//         String username = Jwts.parser()
//                 .setSigningKey(SECRET_KEY)
//                 .parseClaimsJws(token)
//                 .getBody()
//                 .getSubject();

//         if (username != null) {
//             UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//             UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                     userDetails, null, userDetails.getAuthorities());
//             SecurityContextHolder.getContext().setAuthentication(authentication);
//         }

//         chain.doFilter(request, response);
//     }
// }
