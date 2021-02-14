package attachments

class GraffitiAttachment(
    override val type: String = "graffiti",
    val graffiti: Graffiti
) : Attachment