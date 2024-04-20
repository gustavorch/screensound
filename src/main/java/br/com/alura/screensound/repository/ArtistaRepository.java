package br.com.alura.screensound.repository;

import java.util.List;
import java.util.Optional;

import br.com.alura.screensound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.screensound.model.Artista;
import org.springframework.data.jpa.repository.Query;

public interface ArtistaRepository extends JpaRepository<Artista, Long>{

    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artista a JOIN a.musicas WHERE a.nome ILIKE %:nome%")
    List<Musica> buscaMusicasPorArtista(String nome);
}
