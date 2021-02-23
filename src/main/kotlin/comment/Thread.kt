package comment

class Thread(
    val count: Int,
    val items: Array<Comment>?,
    val canPosr: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
)