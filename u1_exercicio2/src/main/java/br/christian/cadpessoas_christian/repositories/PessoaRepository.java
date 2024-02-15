package br.christian.cadpessoas_christian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.christian.cadpessoas_christian.model.Pessoa;

@Repository
public interface PessoaRepository 
        extends JpaRepository<Pessoa, Long>
{
    


}
