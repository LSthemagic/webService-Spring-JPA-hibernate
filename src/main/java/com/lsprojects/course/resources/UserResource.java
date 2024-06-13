package com.lsprojects.course.resources;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsprojects.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// Injeção automática do JdbcTemplate pelo Spring Framework para facilitar a interação com o banco de dados.
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Definição do endpoint HTTP GET para listar usuários pelo ID.
	@SuppressWarnings("deprecation")
	@GetMapping("/listUsers/{id}")
	public ResponseEntity<List<User>> findAll(@PathVariable("id") Long id) throws SQLException {
	    // Retorna uma resposta HTTP 200 OK com o corpo da resposta contendo a lista de usuários.
	    return ResponseEntity.ok()
	        .body(
	            // Consulta SQL para selecionar todos os campos do usuário onde o id corresponde ao parâmetro.
	            jdbcTemplate.query(
	                "select * from tb_user where id = ?",
	                new Object[]{id}, // Passa o id como parâmetro para a consulta SQL.
	                // Mapeia cada linha do ResultSet para um objeto User.
	                (rs, rownum) -> new User(
	                    rs.getLong("id"), // Obtém o campo 'id' como Long.
	                    rs.getString("name"), // Obtém o campo 'name' como String.
	                    rs.getString("email"), // Obtém o campo 'email' como String.
	                    rs.getString("phone"), // Obtém o campo 'phone' como String.
	                    rs.getString("password") // Obtém o campo 'password' como String.
	                )
	            )
	        );
	}


}
