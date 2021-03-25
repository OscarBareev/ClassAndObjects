package comment

import attachments.Attachment

data class Comment(
    val id: Int,
    val postId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut?,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachment: Attachment?,
    val parentsStack: Array<Comment>?,
    val thread: Thread?
)