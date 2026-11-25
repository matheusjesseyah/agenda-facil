package br.com.agenda_facil.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
 
//@Entity informa ao JPA que
// esta classe representa uma tabela no banco
 
@Entity
 
// @Table define o nome da tabela que será criada
// no banco
 
@Table (name = "contatos")
 
public class Contato {
 
    //@Id define o atributo que será a chave primaria da tabela
 
    @Id
 
    //@GenerateValue gera o auto-incremento
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
 
    //@NotBlank impede que o nome seja vazio ou tenha somente espaço
    @NotBlank (message = "O nome é obrigatorio.")
    @Size (max= 100, message = "O nome deve ter no maximo 100 caracteres")
    private String nome;
 
    @NotBlank  (message = "O telefone é obrigatorio")
    @Size (max = 20, message = "O telefone deve ter no máximo 20 caracteres")
    private String telefone;
 
    @NotBlank (message = "O e-mail é obrigatorio")
    @Email(message = "O e-mail deve ter no máximo 100 carateres")
    @Size(max = 100, message = " O e-mail deve ter no maximo 100 caracteres")
    private  String email;
 
   
 // Getter e Setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getTelefone() {
        return telefone;
    }
 
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
 
 
 
 
}