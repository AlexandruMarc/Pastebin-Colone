package dev.alex.pastebin;

import jakarta.persistence.*;

/**
 * Entity class for Paste.
 *
 * Mapped to a database table using @Entity.
 * The primary key 'id' is auto-generated with GenerationType.IDENTITY.
 * The 'content' field has a max length of 5000 characters.
 * Includes getters and setters for 'id' and 'content'.
 */
@Entity
public class Paste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5000)
    private String content;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

