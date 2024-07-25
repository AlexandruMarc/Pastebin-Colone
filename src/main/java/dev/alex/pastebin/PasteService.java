package dev.alex.pastebin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasteService {

    // Injecting PasteRepository for database operations
    @Autowired
    private PasteRepository pasteRepository;

    /**
     * Saves a Paste to the database.
     *
     * @param paste The Paste entity to save.
     * @return The saved Paste entity.
     */
    public Paste savePaste(Paste paste) {
        return pasteRepository.save(paste);
    }

    /**
     * Retrieves all Paste entities.
     *
     * @return List of all Paste entities.
     */
    public List<Paste> getAllPastes() {
        return pasteRepository.findAll();
    }

    /**
     * Retrieves a Paste by its ID.
     *
     * @param id The ID of the Paste to retrieve.
     * @return Optional containing the Paste if found.
     */
    public Optional<Paste> getPasteById(Long id) {
        return pasteRepository.findById(id);
    }
}
