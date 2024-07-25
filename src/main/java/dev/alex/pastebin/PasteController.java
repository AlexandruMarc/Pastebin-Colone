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
    public String getAllPastes(Model model) {
        // Fetching all pastes from the service
        List<Paste> pastes = pasteService.getAllPastes();
        // Adding the list of pastes to the model
        model.addAttribute("pastes", pastes);
        // Returning the view name to display the paste list
        return "paste-list";
    }

    // Mapping to GET /pastes/{id} to retrieve and display a paste by its ID
    @GetMapping("/{id}")
    public String getPasteById(@PathVariable Long id, Model model) {
        // Fetching the paste by its ID, throwing an exception if not found
        Paste paste = pasteService.getPasteById(id).orElseThrow(() -> new IllegalArgumentException("Invalid paste Id:" + id));
        // Adding the paste to the model
        model.addAttribute("paste", paste);
        // Returning the view name to display the paste details
        return "paste-detail";
    }

    // Mapping to POST /pastes to save a new paste
    @PostMapping
    public String savePaste(@RequestParam String content) {
        // Creating a new Paste object
        Paste paste = new Paste();
        // Setting the content of the paste
        paste.setContent(content);
        // Saving the paste using the service
        pasteService.savePaste(paste);
        // Redirecting to the list of pastes after saving
        return "redirect:/pastes";
    }
}
