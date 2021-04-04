package chats

data class Message(
    val id: Int,
    val fromId: Int,
    val toId: Int,
    val text: String,
    var isDeleted: Boolean = false,
    var isRead: Boolean = false,
)