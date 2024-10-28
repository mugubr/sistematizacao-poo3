package com.sistematizacao.sistematizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animais")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> listarAnimais() {
        return animalService.listarAnimais();
    }

    @GetMapping("/{id}")
    public Animal buscarAnimal(@PathVariable Long id) {
        return animalService.buscarAnimalPorId(id);
    }

    @PostMapping
    public Animal cadastrarAnimal(@Validated @RequestBody Animal animal) {
        return animalService.salvarAnimal(animal);
    }

    @PutMapping("/{id}")
    public Animal atualizarAnimal(@PathVariable Long id, @Validated @RequestBody Animal dadosAtualizados) {
        return animalService.atualizarAnimal(id, dadosAtualizados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable Long id) {
        animalService.deletarAnimal(id);
        return ResponseEntity.noContent().build();
    }
}
