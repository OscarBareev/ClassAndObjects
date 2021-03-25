package notes

data class NoteComment(
    val id: Int,
    var noteId: Int,
    val message: String,
    var isDeleted: Boolean = false
)