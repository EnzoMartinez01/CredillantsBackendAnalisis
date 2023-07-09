package com.credillants.credillants.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credillants.credillants.Config.JwtUtilies;
import com.credillants.credillants.Entity.JWTRequest;
import com.credillants.credillants.Entity.JWTResponse;
import com.credillants.credillants.Entity.UsuariosEntity;
import com.credillants.credillants.Service.Imp.UserDetailsServiceImpl;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {
	
	@Autowired
	private UserDetailsServiceImpl userDetail;
	
	@Autowired
	private AuthenticationManager authenticationM;
	
	@Autowired
	private JwtUtilies jwtUtilies;
	
	 @GetMapping("/userlogin")
	    public UsuariosEntity obtenerUsuario(Principal principal){
	        return (UsuariosEntity) userDetail.loadUserByUsername(principal.getName());
	    }

	    @PostMapping("/generartoken")
	    public ResponseEntity<?> generarToken(@RequestBody JWTRequest jwtR) throws Exception{
	        try {
	            this.autenticar(jwtR.getUsername(), jwtR.getPassword());
	        }catch (Exception e){
	            e.printStackTrace();
	            throw new Exception("Usuario no Registrado");
	        }

	        UserDetails userDetails = userDetail.loadUserByUsername(jwtR.getUsername());
	        String token = jwtUtilies.generateToken(userDetails);

	        return ResponseEntity.ok(new JWTResponse(token));
	    }

	    public void autenticar (String username, String password) throws Exception {
	        try {
	            authenticationM.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	        }catch (DisabledException e){
	            throw new Exception("Usuario Desabilitado " + e);
	        }catch (BadCredentialsException be){
	            throw new Exception("Credenciales Erroneas " + be);
	        }
	    }
}
