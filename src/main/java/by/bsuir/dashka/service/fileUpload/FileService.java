package by.bsuir.dashka.service.fileUpload;

import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dashka on 14.05.2015.
 */
@Service
public class FileService  implements IFileService{

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void updatePhoto(Integer id, String photoPath){
        Client client = clientRepository.findOne(id);
        client.setId(client.getId());
        client.setPhoto(photoPath);
        clientRepository.save(client);
    }
}
