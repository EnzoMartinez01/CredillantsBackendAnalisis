package com.credillants.credillants.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credillants.Dto.ResponseDto;
import com.credillants.credillants.Entity.RolEntity;
import com.credillants.credillants.Entity.UsuarioRolEntity;
import com.credillants.credillants.Entity.UsuariosEntity;
import com.credillants.credillants.Service.UsuariosService;
import com.credillants.credillants.Service.Imp.UsuariosServiceImp;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuariosServiceImp userServImp;
	@Autowired
	private UsuariosService userServ;
	
	
    //@ApiOperation(value = "Metodo para listar Usuarios")
	@GetMapping("/obtenerusuarios")
	public ResponseEntity<ResponseDto> readAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userServ.obtenerUsuariosAll());
	}
	
	
    //@ApiOperation(value = "Metodo para crear Usuarios")
	@PostMapping("/registrarusuario")
    public UsuariosEntity agregarUsuario(@RequestBody UsuariosEntity userJsonEntity) throws Exception{
        Set<RolEntity> rolEnt = new HashSet<>();
        Set<UsuarioRolEntity> userRolEnt = new HashSet<>();

        RolEntity rol = new RolEntity();
        rol.setIdRol(1);
        rol.setNombreRol("Cliente");

        UsuarioRolEntity userrol = new UsuarioRolEntity();
        userrol.setUsuariorol(userJsonEntity);
        userrol.setRolusuario(rol);

        userRolEnt.add(userrol);
        return userServImp.crearUsuario(userJsonEntity, userRolEnt);
    }
}
