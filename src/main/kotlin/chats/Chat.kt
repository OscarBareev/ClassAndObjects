package chats

data class Chat(
    val id: Int,
    val ownerId: Int,
    var messages: ArrayList<Message>,
    var isDeleted: Boolean = false,
)