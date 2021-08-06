import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestController {

    @Autowired
    private ContactRepository repo;

    @RequestMapping("/contacts")
    public List<Contact> getAll() {
        return repo.findAll();
    }
}