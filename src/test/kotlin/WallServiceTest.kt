import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

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