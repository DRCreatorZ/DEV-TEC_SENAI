package webapp.crud_escola.repository;

import org.springframework.data.repository.CrudRepository;
import webapp.crud_escola.model.VerificaCadastroAdm;

public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdm, String> {

    VerificaCadastroAdm findByCpf(String cpf);
    VerificaCadastroAdm findByNome (String nome);

}
