package attachments

import notes.Note

class NoteAttachment(
    override val type: String = "note",
    val note: Note
) : Attachment