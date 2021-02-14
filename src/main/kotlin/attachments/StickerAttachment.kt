package attachments

class StickerAttachment(
    override val type: String = "sticker",
    sticker: Sticker
) : Attachment