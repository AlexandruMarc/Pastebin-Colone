package dev.alex.pastebin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Repository interface for managing Paste entities.
@Repository
public interface PasteRepository extends JpaRepository<Paste, Long> {
}

