package org.example.RealTimeSocialMediaFeedAggregation;

public abstract class SocialMediaPostValidator {
    protected SocialMediaPostValidator next;
    public void setNext(SocialMediaPostValidator next){
        this.next=next;
    }
    public boolean validate(Post post){
        if(!doValidate(post))return false;
        return next==null || next.doValidate(post);
    }
    public abstract boolean doValidate(Post post);
}
