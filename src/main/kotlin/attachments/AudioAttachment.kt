package attachments

class AudioAttachment(
    override val type: String = "audio",
    val audio: Audio
) : Attachment