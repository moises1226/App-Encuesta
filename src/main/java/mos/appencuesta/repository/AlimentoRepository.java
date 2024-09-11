package mos.appencuesta.repository;

import mos.appencuesta.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlimentoRepository extends JpaRepository<Alimento , Long> {

}
