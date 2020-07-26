package ImageHoster.controller;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import ImageHoster.service.ImageService;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String newComment(@RequestParam("comment") String comment, Image image, HttpSession session, @PathVariable int imageId, @PathVariable String imageTitle, Comments newComment) throws IOException {
        System.out.println("suc1");
        User user = (User) session.getAttribute("loggeduser");
        newComment.setUser(user);
        newComment.setText(comment);
        image.setId(imageId);
        image.setTitle(imageTitle);
        newComment.setImage(image);
        newComment.setCreatedDate(new Date());
        commentService.updateComment(newComment);
        return "redirect:/images/{imageId}/{imageTitle}";
    }
}
