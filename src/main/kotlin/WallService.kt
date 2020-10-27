object WallService {

    private var posts = emptyArray<Post>()
    private val randomId = posts.size + 1


    fun add(post: Post): Post {

        val idPost = post.copy(id = randomId)

        posts += idPost
        return posts.last()
    }

    fun update(newPost: Post): Boolean {

        var hasIndex = false


        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(ownerId = post.ownerId, date = post.date)
                hasIndex = true
            }
        }
        return hasIndex
    }
}
