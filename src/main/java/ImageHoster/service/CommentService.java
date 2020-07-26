package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private ImageRepository imageRepository;
    public void updateComment(Comments comment) {
        imageRepository.updateComment(comment);
    }
}
