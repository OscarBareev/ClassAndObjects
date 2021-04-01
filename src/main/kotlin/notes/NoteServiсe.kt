package notes


object NoteService {
    private var notes = ArrayList<Note>()
    private var comments = ArrayList<NoteComment>()

    fun cleanAll(){
        notes.clear()
        comments.clear()
    }

    fun add(title: String, text: String): Int {
        val newNote = Note(title = title, text = text, id = notes.size + 1)
        notes.add(newNote)
        return notes.last().id
    }

    fun createComment(message: String, noteId: Int): Int {
        var check = false

        for (n in notes) {
            if (n.id == noteId) check = true
        }

        if (check) {
            val newComment = NoteComment(message = message, noteId = noteId, id = comments.size + 1)
            comments.add(newComment)
        } else {
            throw NoteNotFoundException("There are no notes with $noteId Id")
        }
        return comments.last().id
    }

    fun delete(noteId: Int): Int {
        var check = 0

        for (n in notes) {
            if (noteId == n.id) {
                n.isDeleted = true
                check = 1
                for (c in comments) {
                    if (c.noteId == noteId) {
                        deleteComment(c.noteId)
                    }
                }
            }
        }

        return check
    }

    fun deleteComment(commentId: Int): Int {
        var check = 0

        for (c in comments) {
            if (commentId == c.id) {
                c.isDeleted = true
                check = 1
            }
        }

        return check
    }

    fun edit(note: Note, title: String, text: String): Int {

        var check = 0

        for ((index, n) in notes.withIndex()) {
            if (n.id == note.id && !n.isDeleted) {
                notes[index] = note.copy(title = title, text = text)
                check = 1
            }
        }
        return check
    }

    fun editComment(comment: NoteComment, message: String): Int {
        var check = 0

        for ((index, c) in comments.withIndex()) {
            if (c.id == comment.id && !c.isDeleted) {
                comments[index] = comment.copy(message = message)
                check = 1
            }
        }
        return check
    }

    fun get(): Int {
        var check = 0
        for (n in notes) {
            if (!n.isDeleted) {
                println(n)
                check = 1
            }
        }
        return check
    }


    fun getComment(): Int {

        var check = 0
        for (c in comments) {
            if (!c.isDeleted) println(c)
            check = 1
        }
        return check
    }

    fun restoreComments(commentId: Int): Int {
        var check = 0

        for (c in comments) {
            if (commentId == c.id) {
                c.isDeleted = false
                check = 1
            }
        }

        return check
    }
}
