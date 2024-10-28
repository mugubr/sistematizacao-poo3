package com.sistematizacao.sistematizacao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> listarAnimais() {
        return animalRepository.findAll();
    }

    public Animal buscarAnimalPorId(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Animal não encontrado"));
    }

    public Animal salvarAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal atualizarAnimal(Long id, Animal dadosAtualizados) {
        Animal animal = buscarAnimalPorId(id);

        animal.setNome(dadosAtualizados.getNome());
        animal.setTipo(dadosAtualizados.getTipo());
        animal.setIdade(dadosAtualizados.getIdade());
        animal.setRaca(dadosAtualizados.getRaca());
        animal.setStatusAdocao(dadosAtualizados.getStatusAdocao());
        animal.setDescricao(dadosAtualizados.getDescricao());
        animal.setImagemUrl(dadosAtualizados.getImagemUrl());

        return animalRepository.save(animal);
    }

    public void deletarAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}

