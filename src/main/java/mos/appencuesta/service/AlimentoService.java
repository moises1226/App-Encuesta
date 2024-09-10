package mos.appencuesta.service;

import mos.appencuesta.model.Alimento;
import mos.appencuesta.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService implements IAlimentoService {

    @Autowired
    AlimentoRepository alimentoRepository;

    public Alimento guardarDatos(String nFood , String nDrink , String nDessert){

        Alimento alimento = new Alimento();
        alimento.setNameFood(nFood);
        alimento.setNameDrink(nDrink);
        alimento.setNameDessert(nDessert);

        return alimentoRepository.save(alimento);

    }

    @Override
    public List<Alimento> getAllAlimento() {
        return alimentoRepository.findAll();
    }

    @Override
    public void DeleteAlimento(Long id) {

        alimentoRepository.deleteById(id);

    }
}

