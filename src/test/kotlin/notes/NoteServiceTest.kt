package notes

import comment.Comment
import comment.PostNotFoundException
import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {

        val title = "Here is a title"
        val text = "Here is the text"

        val result = NoteService.add(title, text)

        assertFalse(result == 0)
    }


    @Test(expected = NoteNotFoundException::class)
    fun createComment_exception() {

        val message = "Hello world!"
        val noteId = 999

        NoteService.createComment(message, noteId)
    }

    @Test
    fun createComment() {

        val title = "Here is a title"
        val text = "Here is the text"
        val message = "Hello world!"
        val noteId = 1

        NoteService.add(title, text)

        val result = NoteService.createComment(message, noteId)

        assertFalse(result == 0)
    }


    @Test
    fun delete() {

        val title = "Here is a title"
        val text = "Here is the text"
        val noteId = 1

        NoteService.add(title, text)

        val result = NoteService.delete(noteId)

        assert(result == 1)
    }

    @Test
    fun delete_notExist() {

        val title = "Here is a title"
        val text = "Here is the text"
        val noteId = 999

        NoteService.add(title, text)

        val result = NoteService.delete(noteId)

        assert(result == 0)
    }


    @Test
    fun deleteComment() {

        val title = "Here is a title"
        val text = "Here is the text"
        val message = "Hello world!"
        val noteId = 1

        NoteService.add(title, text)
        NoteService.createComment(message, noteId)

        val result = NoteService.deleteComment(noteId)

        assert(result == 1)
    }

    @Test
    fun deleteComment_notExist() {

        val title = "Here is a title"
        val text = "Here is the text"
        val message = "Hello world!"
        val noteId = 1
        val commentId = 999

        NoteService.add(title, text)
        NoteService.createComment(message, noteId)

        val result = NoteService.deleteComment(commentId)

        assert(result == 0)
    }

    @Test
    fun edit() {
        val title = "Here is a title"
        val text = "Here is the text"
        val note = Note(1, title, text)
        NoteService.add(title, text)

        val result = NoteService.edit(note, "Hello", "World")

        assert(result == 1)
    }

    @Test
    fun editComment() {

        val title = "Here is a title"
        val text = "Here is the text"
        val message = "Hello world!"
        val noteId = 1
        val commentId = 1
        val comment = NoteComment(commentId, noteId, message)

        NoteService.add(title, text)
        NoteService.createComment(message, noteId)

        val result = NoteService.editComment(comment, message)

        assert(result == 1)
    }

    @Test
    fun get() {
        val title = "Here is a title"
        val text = "Here is the text"
        NoteService.add(title, text)

        val result = NoteService.get()

        assert(result == 1)
    }

    @Test
    fun getComment() {

        val title = "Here is a title"
        val text = "Here is the text"
        val message = "Hello world!"
        val noteId = 1



        NoteService.add(title, text)
        NoteService.createComment(message, noteId)

        val result = NoteService.getComment()

        assert(result == 1)
    }

    @Test
    fun restoreComments() {

        val title = "Here is a title"
        val text = "Here is the text"
        val message = "Hello world!"
        val noteId = 1



        NoteService.add(title, text)
        NoteService.createComment(message, noteId)

        val result = NoteService.restoreComments(noteId)


        assert(result == 1)

    }
}