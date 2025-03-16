package org.example.Twitter;

import java.util.List;

public class TwitterDemo {
    public static void main(String[] args) {
        Twitter twitter=Twitter.getInstance();
        User viratKohli=twitter.addUser("virat kohli");
        User mahi=twitter.addUser("Dhoni");
        User rohitSharma=twitter.addUser("Rohit Sharma");
        User elonMusk=twitter.addUser("Elon");

        User vikas=twitter.addUser("vikas");


        twitter.followUser(vikas.getName(), viratKohli.getName());
        twitter.followUser(vikas.getName(), mahi.getName());
        twitter.followUser(vikas.getName(), rohitSharma.getName());
        twitter.followUser(vikas.getName(), elonMusk.getName());

        twitter.followUser(rohitSharma.getName(), vikas.getName());
        twitter.followUser(rohitSharma.getName(), viratKohli.getName());

        twitter.postTweet(elonMusk.getName(), "Tesla is amazing!");
        twitter.postTweet(rohitSharma.getName(), "We won Champions Trophy!");
        twitter.postTweet(mahi.getName(), "Excited for the upcoming IPL! whistlepodu!");
        twitter.postTweet(viratKohli.getName(), "RCB!!!!!!");

        twitter.postTweet(vikas.getName(),"Congratulations India! #CT2025");
        twitter.postTweet(viratKohli.getName(), "Ocean is amazing!");
        twitter.postTweet(viratKohli.getName(), "Ee Saala cup named! #IPL2025 #RCB");

        displayTweetsForUser(twitter, vikas, 10);
        System.out.println("--------------------------");
        displayTweetsForUser(twitter, rohitSharma,10);

    }
    public static void displayTweetsForUser(Twitter twitter, User user, int k){
        List<Tweet>tweetsForUser=twitter.generateTimelineForUser(user.getName(), k);

        tweetsForUser.forEach(tweet-> System.out.println(tweet.getAuthor().getName()+": "+tweet.getContent()+" "));
    }
}
