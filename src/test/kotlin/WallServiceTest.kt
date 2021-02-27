import comment.Comment

import org.junit.Test
import comment.PostNotFoundException


import org.junit.Assert.*
import java.lang.AssertionError

class WallServiceTest {


    @Test
    fun comment_existPost() {

        val post = Post(
            id = 1,
            ownerId = 1,
            fromId = 1,
            date = 1234,
            text = "Hello",
            replyOwnerId = 2,
            replyPostId = 2,
            friendsOnly = false,
            comment = 4,
            copyright = "5",
            likes = 1,
            reposts = 3,
            views = 4,
            postType = "Hello",
            postSource = null,
            attachment = null,
            geo = null,
            signerId = 5,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 4
        )

        WallService.add(post)

        val comment = Comment(
            id = 1,
            postId = 1,
            fromId = 1,
            date = 1,
            text = "text",
            donut = null,
            replyToUser = 1,
            replyToComment = 1,
            attachment = null,
            parentsStack = null,
            thread = null
        )

        val result = WallService.createComment(comment)

        assertTrue(result.postId == post.id)
    }



    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException
        /*val post = Post(
            id = 2,
            ownerId = 1,
            fromId = 1,
            date = 1234,
            text = "Hello",
            replyOwnerId = 2,
            replyPostId = 2,
            friendsOnly = false,
            comment = 4,
            copyright = "5",
            likes = 1,
            reposts = 3,
            views = 4,
            postType = "Hello",
            postSource = null,
            attachment = null,
            geo = null,
            signerId = 5,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 4
        )

        WallService.add(post)*/

        val comment = Comment(
            id = 9,
            postId = 9,
            fromId = 1,
            date = 1,
            text = "text",
            donut = null,
            replyToUser = 1,
            replyToComment = 1,
            attachment = null,
            parentsStack = null,
            thread = null
        )

        WallService.createComment(comment)

    }


    /*   @Test
       fun comment_notExistPost() {

           val post = Post(
               id = 2,
               ownerId = 1,
               fromId = 1,
               date = 1234,
               text = "Hello",
               replyOwnerId = 2,
               replyPostId = 2,
               friendsOnly = false,
               comment = 4,
               copyright = "5",
               likes = 1,
               reposts = 3,
               views = 4,
               postType = "Hello",
               postSource = null,
               attachment = null,
               geo = null,
               signerId = 5,
               copyHistory = null,
               canPin = true,
               canDelete = true,
               canEdit = true,
               isPinned = true,
               markedAsAds = true,
               isFavorite = true,
               postponedId = 4
           )

           WallService.add(post)

           val comment = Comment(
               id = 1,
               postId = 1,
               fromId = 1,
               date = 1,
               text = "text",
               donut = null,
               replyToUser = 1,
               replyToComment = 1,
               attachment = null,
               parentsStack = null,
               thread = null
           )

           try {
               WallService.createComment(comment)
               fail()
           } catch (e: PostNotFoundException) {
               assertEquals("There are no posts with this Id", e.message);
           }

       }*/


    @Test
    fun add() {

        val post = Post(
            id = 1,
            ownerId = 1,
            fromId = 1,
            date = 1234,
            text = "Hello",
            replyOwnerId = 2,
            replyPostId = 2,
            friendsOnly = false,
            comment = 4,
            copyright = "5",
            likes = 1,
            reposts = 3,
            views = 4,
            postType = "Hello",
            postSource = null,
            attachment = null,
            geo = null,
            signerId = 5,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 4
        )

        val result = WallService.add(post)


        assertFalse(result.id === 0)


    }

    @Test
    fun update_sameIndex() {

        val newPost = Post(
            id = 1,
            ownerId = 1,
            fromId = 1,
            date = 1234,
            text = "Hello",
            replyOwnerId = 2,
            replyPostId = 2,
            friendsOnly = false,
            comment = 4,
            copyright = "5",
            likes = 1,
            reposts = 3,
            views = 4,
            postType = "Hello again",
            postSource = null,
            attachment = null,
            geo = null,
            signerId = 5,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 4
        )


        val result = WallService.update(newPost)

        assertTrue(result)
    }


    @Test
    fun update_otherIndex() {

        val newPost = Post(
            id = 123,
            ownerId = 1,
            fromId = 1,
            date = 1234,
            text = "Hello",
            replyOwnerId = 2,
            replyPostId = 2,
            friendsOnly = false,
            comment = 4,
            copyright = "5",
            likes = 1,
            reposts = 3,
            views = 4,
            postType = "Hello again",
            postSource = null,
            attachment = null,
            geo = null,
            signerId = 5,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 4
        )


        val result = WallService.update(newPost)

        assertFalse(result)
    }


}