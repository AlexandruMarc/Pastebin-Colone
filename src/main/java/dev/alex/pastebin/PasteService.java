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
     */
    public void savePaste(Paste paste) {
        pasteRepository.save(paste);
    }

    /**
     * Retrieves all Paste entities.
     *
     * @return List of all Paste entities.
     */
    public List<Paste> getAll() {
        return pasteRepository.findAll();
    }

    /**
     * Retrieves a Paste by its ID.
     *
     * @param id The ID of the Paste to retrieve.
     * @return Optional containing the Paste if found.
     */
    public Optional<Paste> getById(Long id) {
        return pasteRepository.findById(id);
    }
}
