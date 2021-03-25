import attachments.Attachment
import attachments.NoteAttachment

data class  Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comment: Long,
    val copyright: String,
    val likes: Long,
    val reposts: Long,
    val views: Long,
    val postType: String,
    val postSource: PostSource?,
    val attachment: Array<Attachment>?,
    val geo: Geo?,
    val signerId: Int,
    val copyHistory: Array<Post>?,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int
)