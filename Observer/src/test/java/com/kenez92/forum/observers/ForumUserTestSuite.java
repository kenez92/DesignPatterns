package com.kenez92.forum.observers;

import com.kenez92.forum.ForumTopic;
import com.kenez92.forum.topics.JavaHelpForumTopic;
import com.kenez92.forum.topics.JavaToolsForumTopic;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForumUserTestSuite {

    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser( "Ivone Escobar");
        ForumUser jessiePinkman = new ForumUser( "Jessie Pinkman");
        javaHelpForum.registerObserver(johnSmith);
        javaToolsForum.registerObserver(ivoneEscobar);
        javaHelpForum.registerObserver(jessiePinkman);
        javaToolsForum.registerObserver(jessiePinkman);
        //When
        javaHelpForum.addPost("Hi everyone! Could you help me with for loop?");
        javaHelpForum.addPost("Better try to use while looop in this case");
        javaToolsForum.addPost("Help pls, my MySQL db doesn't want to work :(");
        javaHelpForum.addPost("Why while? is it better?");
        javaToolsForum.addPost("When I try to log in i got 'bad credentials' message.");
        //Then
        Assert.assertEquals(3, johnSmith.getUpdateCount());
        Assert.assertEquals(2, ivoneEscobar.getUpdateCount());
        assertEquals(5, jessiePinkman.getUpdateCount());
    }

}