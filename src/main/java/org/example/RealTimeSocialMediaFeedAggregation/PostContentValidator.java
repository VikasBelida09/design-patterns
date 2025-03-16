package org.example.RealTimeSocialMediaFeedAggregation;

import java.util.Objects;
import java.util.Set;

public class PostContentValidator extends SocialMediaPostValidator{
    private final Set<String>contentNotAllowed;
    public PostContentValidator(Set<String>contentNotAllowed){
        this.contentNotAllowed=contentNotAllowed;
    }
    @Override
    public boolean doValidate(Post post) {
        if(!Objects.isNull(post.getContent()) || post.getContent().length() <1 ||contentNotAllowed.contains(post.getContent())){
            System.out.println("Post failed validation: "+ post);
            return false;
        }
        return next.doValidate(post);
    }
}
