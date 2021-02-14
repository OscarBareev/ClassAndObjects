package attachments

class NoteAttachment(
    override val type: String = "note",
    val note: Note
) : Attachment