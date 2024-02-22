package br.com.produts.store.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO{

    private Long id;
    private String name;
    private String email;
    private String password;



}