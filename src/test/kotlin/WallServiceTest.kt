import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {

        val post = Post( 1,
            1,
            1,
            1234,
            "Hello",
            2,
            2,
            false,
            4,
            "5",
            1,
            3,
            4,
            "Hello",
            5,
            true,
            true,
            true,
            true,
            true,
            true,
            4)

        val result = WallService.add(post)


        assertFalse(result.id === 0)


    }

    @Test
    fun update_sameIndex() {

        val newPost = Post(
            1,
            1,
            1,
            1234,
            "Hello",
            2,
            2,
            false,
            4,
            "5",
            1,
            3,
            4,
            "Hello again",
            5,
            true,
            true,
            true,
            true,
            true,
            true,
            4)


        val result = WallService.update(newPost)

        assertTrue(result)
    }


    @Test
    fun update_otherIndex() {

        val newPost = Post(
            123,
            1,
            1,
            1234,
            "Hello",
            2,
            2,
            false,
            4,
            "5",
            1,
            3,
            4,
            "Hello again",
            5,
            true,
            true,
            true,
            true,
            true,
            true,
            4)


        val result = WallService.update(newPost)

        assertFalse(result)
    }



}