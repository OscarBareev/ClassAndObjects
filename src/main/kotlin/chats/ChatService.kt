package chats

import java.util.function.BinaryOperator

object ChatService {

    private var chats = ArrayList<Chat>()
    private var idList = ArrayList<Int>()


    //Вспомогательные функции

    fun clearAll() {
        chats.clear()
        idList.clear()
    }

    private fun addId(): Int {
        idList.add(idList.size + 1)
        return idList.size
    }


    //Основные функции

    fun createChat(userId: Int, message: Message): Message {

        val messageArray = ArrayList<Message>()
        messageArray.add(message)
        val newChat = Chat(addId(), userId, messageArray)
        chats.add(newChat)
        return chats.last().messages.last()
    }

    fun deleteChat(chatId: Int): Boolean {

        var check: Boolean = false

        chats.forEach { c ->
            if (c.id == chatId) c.isDeleted = true
            check = c.isDeleted
        }
        return check
    }

    fun addMessage(fromId: Int, toId: Int, chatId: Int, text: String): Boolean {

        var check = false

        val newMessage = Message(addId(), fromId, toId, text)

        chats.forEach { c ->

            if (c.id == chatId) {
                c.messages.add(newMessage)
                check = true
            }
        }
        return check
    }


    fun editMessages(chatId: Int, messageId: Int, fromId: Int, newText: String): Boolean {

        var check = false

        chats.forEach { c ->
            if (c.id == chatId) {
                c.messages.forEachIndexed { index, m ->
                    if (m.id == messageId && fromId == m.fromId) {
                        c.messages[index] = m.copy(text = newText)
                        check = true
                    }
                }
            }
        }

        return check
    }

    fun deleteMessage(chatId: Int, messageId: Int, fromId: Int): Boolean {

        var check = false

        chats.forEach { c ->
            if (c.id == chatId) {
                c.messages.forEach { m ->
                    if (m.id == messageId && fromId == m.fromId) {
                        m.isDeleted = true
                        check = m.isDeleted
                    }
                }
            }
            if (c.messages.filter { it.isDeleted }.isEmpty()) deleteChat(chatId)
        }
        return check
    }

    fun getUnreadChatsCount(userId: Int): Int {
        val filteredChats = chats.filter { isContainUnread(userId, it.messages) }
        return filteredChats.size
    }

    private fun isContainUnread(userId: Int, msgArr: ArrayList<Message>): Boolean {
        var check = false
        msgArr.filter { it.toId == userId }.forEach { m ->
            if (!m.isRead) {
                check = true
            }
        }
        return check
    }

    fun getChats(ownerId: Int): Boolean {

        var check = false

        val filteredChats = chats.filter { it.ownerId == ownerId }.filter { it.messages.isNotEmpty() }
        if (filteredChats.isNotEmpty()) {
            println(filteredChats)
            check = true
        } else {
            println("No messages")
        }
        return check
    }

    fun getMessages(chat: Chat):Boolean {

        var check = false

        chat.messages.forEach { m ->
            println("Id чата: ${chat.id}" + "; Id последнего сообщения: ${chat.messages.last().id}" +
                    "; Кол-во сообщений: ${chat.messages.size}")
            println(m)
            m.isRead = true
            check = m.isRead
        }

        return check
    }

}