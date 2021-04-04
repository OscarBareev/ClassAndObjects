package chats

import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    @Test
    fun createChat() {

        val message = Message(id = 999, fromId = 2, text = "text", toId = 3)

        val result = ChatService.createChat(userId = 333, message)

        assertTrue(message.id == result.id)

        ChatService.clearAll()


    }

    @Test
    fun deleteChat_isExist() {

        val message = Message(id = 999, fromId = 2, text = "text", toId = 3)

        ChatService.createChat(userId = 333, message)

        val result = ChatService.deleteChat(1)

        assertTrue(result)

        ChatService.clearAll()

    }

    @Test
    fun deleteChat_isNotExist() {

        val message = Message(id = 999, fromId = 2, text = "text", toId = 3)

        ChatService.createChat(userId = 333, message)

        val result = ChatService.deleteChat(100)

        assertFalse(result)

        ChatService.clearAll()

    }

    @Test
    fun addMessage_chatExist() {
        val message = Message(id = 999, fromId = 2, text = "text", toId = 3)

        ChatService.createChat(userId = 333, message)

        val result = ChatService.addMessage(fromId = 111, toId = 222, chatId = 1, text = "text")

        assertTrue(result)

        ChatService.clearAll()
    }

    @Test
    fun addMessage_chatNotExist() {


        val result = ChatService.addMessage(fromId = 111, toId = 222, chatId = 1, text = "text")

        println(result)

        assertFalse(result)

        ChatService.clearAll()
    }


    @Test
    fun editMessages() {

        val fromId = 333
        val messageId = 555

        val message = Message(id = messageId, fromId, text = "text", toId = 3)

        ChatService.createChat(userId = 333, message)// chatId = 1

        val result = ChatService.editMessages(chatId = 1, messageId, fromId, newText = "newText")

        assertTrue(result)

        ChatService.clearAll()
    }


    @Test
    fun deleteMessage() {
        val fromId = 333
        val messageId = 555

        val message = Message(id = messageId, fromId, text = "text", toId = 3)

        ChatService.createChat(userId = 333, message)// chatId = 1

        val result = ChatService.deleteMessage(chatId = 1, messageId, fromId)

        assertTrue(result)

        ChatService.clearAll()
    }


    @Test
    fun getUnreadChatsCount() {


        val toId = 777

        val message = Message(id = 999, fromId = 2, text = "text", toId = toId, isRead = false)

        ChatService.createChat(userId = 333, message) //create chat with one unread message

        val result = ChatService.getUnreadChatsCount(toId)

        assert(result == 1)

        ChatService.clearAll()

    }

    @Test
    fun getChats() {

        val ownerId = 999
        val message = Message(id = 999, fromId = 2, text = "text", toId = 111, isRead = false)

        ChatService.createChat(ownerId, message)
        val result = ChatService.getChats(ownerId)

        assertTrue(result)

        ChatService.clearAll()
    }

    @Test
    fun getMessages() {


        val message = Message(id = 999, fromId = 2, text = "text", toId = 111, isRead = false)
        var newArray =  ArrayList<Message>()
        newArray.add(message)

        val newChat = Chat(111, 222,newArray)

        val result = ChatService.getMessages(newChat)

        assertTrue(result)

        ChatService.clearAll()

    }

}