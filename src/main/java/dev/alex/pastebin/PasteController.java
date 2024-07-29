package dev.alex.pastebin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pastes")
public class PasteController {

    // Autowiring the PasteService to use its methods
    @Autowired
    private PasteService pasteService;

    // Mapping to GET /pastes to retrieve and display all pastes
    @GetMapping
    public String getAll(Model model) {
        // Fetching all pastes from the service
        List<Paste> pastes = pasteService.getAll();
        model.addAttribute("pastes", pastes);
        return "paste-list";
    }

    // Mapping to GET /pastes/{id} to retrieve and display a paste by its ID
    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        // Fetching the paste by its ID, throwing an exception if not found
        Paste paste = pasteService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid paste Id:" + id));
        model.addAttribute("paste", paste);
        return "paste-detail";
    }

    // Mapping to POST /pastes to save a new paste
    @PostMapping
    public String savePaste(@RequestParam String content) {
        Paste paste = new Paste();
        paste.setContent(content);
        pasteService.savePaste(paste);
        // Redirecting to the list of pastes after saving
        return "redirect:/pastes";
    }
}
