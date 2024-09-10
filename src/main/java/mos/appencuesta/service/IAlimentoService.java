package mos.appencuesta.service;

import mos.appencuesta.model.Alimento;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IAlimentoService {

    public List<Alimento> getAllAlimento();

    public void DeleteAlimento(Long id);

}
