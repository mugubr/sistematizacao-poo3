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

    public Animal salvarAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        atualizarDadosAnimal(animal, animalDTO);
        return animalRepository.save(animal);
    }

    public Animal atualizarAnimal(Long id, AnimalDTO dadosAtualizados) {
        Animal animal = buscarAnimalPorId(id);
        atualizarDadosAnimal(animal, dadosAtualizados);
        return animalRepository.save(animal);
    }

    private void atualizarDadosAnimal(Animal animal, AnimalDTO dadosAtualizados) {
        animal.setNome(dadosAtualizados.getNome());
        animal.setTipo(dadosAtualizados.getTipo());
        animal.setIdade(dadosAtualizados.getIdade());
        animal.setRaca(dadosAtualizados.getRaca());
        animal.setStatusAdocao(dadosAtualizados.getStatusAdocao());
        animal.setDescricao(dadosAtualizados.getDescricao());
        animal.setImagemUrl(dadosAtualizados.getImagemUrl());
    }

    public void deletarAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
