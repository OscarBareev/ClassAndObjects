package attachments

class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo
) : Attachment