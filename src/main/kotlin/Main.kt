import attachments.*

fun main() {

    var attachments = emptyArray<Attachment>()
    val audio = Audio(
        1,
        1,
        "Artist",
        "hello",
        1,
        "url",
        1,
        1,
        1,
        1,
        1,
        1
    )

    val note = Note(1, "name", "one", "two")

    if (audio is Audio) {
        var audioAttachment = AudioAttachment(audio = audio)
        attachments += audioAttachment
    }

    if (note is Note) {
        var noteAttachment = NoteAttachment(note = note)
        attachments += noteAttachment
    }


    val original = Post(
        id = 1,
        ownerId = 1,
        fromId = 1,
        date = 1234,
        text = "Hello",
        replyOwnerId = 2,
        replyPostId = 2,
        friendsOnly = false,
        comment = 4,
        copyright = "5",
        likes = 1,
        reposts = 3,
        views = 4,
        postType = "newType",
        postSource = null,
        attachment = attachments,
        geo = null,
        signerId = 5,
        copyHistory = null,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = true,
        markedAsAds = true,
        isFavorite = true,
        postponedId = 4
    )

    val newPost = original.copy(text = "Hello Everyone!")

    WallService.add(original)
    WallService.update(newPost)

    val result = WallService.add(original).id

    print(result)

}