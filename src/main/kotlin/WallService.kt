import comment.Comment
import comment.PostNotFoundException

object WallService {

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()


    private val randomId = posts.size + 1


    fun createComment(comment: Comment): Comment
    {


        findById(comment.postId) ?: throw PostNotFoundException("No id")
        comments += comment


        /* var check = false

         for (post in posts) {
             if (post.id == comment.postId) {
                 check = true
             }
         }

         if (check) {
             comments += comment
         } else {
             throw PostNotFoundException("There are no posts with this Id")
         }*/

        return comments.last()
    }

    fun findById(id: Int): Post? {

        var result: Post? = null

        for (post in posts) {
            if (post.id == id) {
                result = post
            }
        }
        return result
    }


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